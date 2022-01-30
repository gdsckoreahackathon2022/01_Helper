/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MainActivity.kt] created by Ji Sungbin on 22. 1. 23. 오후 8:58
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
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
import team.gdsc.shelper.activity.guide.GuideActivity
import team.gdsc.shelper.databinding.ActivityMapBinding
import team.gdsc.shelper.util.NetworkUtil
import team.gdsc.shelper.util.constant.IntentConstant
import team.gdsc.shelper.util.extension.runIf
import team.gdsc.shelper.util.extension.toast

@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var initLocateService = false
    private lateinit var map: GoogleMap
    private var lastLocate = LatLng(Double.NaN, Double.NaN)
    private lateinit var binding: ActivityMapBinding
    private val vm: MapViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)

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

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
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

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnOpenDrawer.setOnClickListener {
            binding.dlContainer.open()
        }

        binding.tvGuide.setOnClickListener {
            println("CLICKED")
            logeukes { "CC" }
            startActivity(Intent(this, GuideActivity::class.java))
        }

        binding.nvDrawer.setOnClickListener {
            logeukes { "AA" }
        }

        binding.nvDrawer.setNavigationItemSelectedListener {
            logeukes { "BB" }
            true
        }
    }

    @SuppressLint("MissingPermission")
    private fun startLocationService() {
        Locus.startLocationUpdates(this) { result ->
            result.location?.let { location ->
                lastLocate = LatLng(location.latitude, location.longitude)
                if (!initLocateService) {
                    initLocateService = true
                    map.isMyLocationEnabled = true
                    map.uiSettings.isMyLocationButtonEnabled = true
                    moveCameraAndZoom(lastLocate)
                    binding.btnRefresh.visibility = View.VISIBLE
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
            // max: 21f
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

    override fun onBackPressed() {
        if (binding.dlContainer.isOpen) {
            binding.dlContainer.close()
        } else {
            super.onBackPressed()
        }
    }

    override fun onPause() {
        Locus.stopLocationUpdates()
        super.onPause()
    }
}
