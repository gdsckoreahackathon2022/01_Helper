/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MainActivity.kt] created by Ji Sungbin on 22. 1. 23. 오후 8:58
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.birjuvachhani.locus.Locus
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import team.gdsc.shelper.R
import team.gdsc.shelper.activity.error.ErrorActivity
import team.gdsc.shelper.util.NetworkUtil
import team.gdsc.shelper.util.constant.IntentConstant
import team.gdsc.shelper.util.extension.runIf
import team.gdsc.shelper.util.extension.toast

@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var initLocateService = false
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!NetworkUtil.isNetworkAvailable(applicationContext)) {
            finish()
            startActivity(
                Intent(this, ErrorActivity::class.java).apply {
                    putExtra(IntentConstant.Error, IntentConstant.NoInternet)
                }
            )
            return
        }

        toast(getString(R.string.activity_map_loading_locate))
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        startLocationService()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                splashScreenView.animate().run {
                    alpha(0f)
                    scaleX(0f)
                    scaleY(0f)
                    interpolator = AnticipateInterpolator()
                    duration = 200L
                    withEndAction { splashScreenView.remove() }
                    withLayer()
                    start()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationService() {
        Locus.startLocationUpdates(this) { result ->
            result.location?.let { location ->
                val (latitude, longitude) = listOf(location.latitude, location.longitude)
                val locate = LatLng(latitude, longitude)
                // marking(latitude, longitude)
                if (!initLocateService) {
                    initLocateService = true
                    map.isMyLocationEnabled = true
                    map.uiSettings.isMyLocationButtonEnabled = true
                    moveCameraAndZoom(locate)
                }
            }
            result.error?.let { exception ->
                logeukes(type = LoggerType.E) { exception }
            }
        }
    }

    private fun marking(locate: LatLng, title: String = "") {
        if (::map.isInitialized) {
            map.addMarker(
                MarkerOptions()
                    .position(locate)
                    .runIf(title != "") { title(title) }
            )
        }
    }

    private fun moveCameraAndZoom(locate: LatLng) {
        if (::map.isInitialized) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(locate, 18f))
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setPadding(30, 120, 30, 30)
        map.uiSettings.run {
            isZoomControlsEnabled = true
            setAllGesturesEnabled(true)
        }
    }

    override fun onPause() {
        Locus.stopLocationUpdates()
        super.onPause()
    }
}
