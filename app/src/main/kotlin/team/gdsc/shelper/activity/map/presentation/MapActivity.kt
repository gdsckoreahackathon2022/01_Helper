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
import team.gdsc.shelper.BuildConfig
import team.gdsc.shelper.R
import team.gdsc.shelper.activity.contact.ContactActivity
import team.gdsc.shelper.activity.error.ErrorActivity
import team.gdsc.shelper.activity.guide.GuideActivity
import team.gdsc.shelper.activity.information.InformationActivitty
import team.gdsc.shelper.activity.map.constant.PlaceType
import team.gdsc.shelper.activity.map.model.domain.PlaceFindResult
import team.gdsc.shelper.databinding.ActivityMapBinding
import team.gdsc.shelper.util.NetworkUtil
import team.gdsc.shelper.util.constant.IntentConstant
import team.gdsc.shelper.util.extension.collectWithLifecycle
import team.gdsc.shelper.util.extension.toast

@AndroidEntryPoint
class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private var firstRequest = true
    private var initLocateService = false
    private var lastLocate = LatLng(Double.NaN, Double.NaN)

    private lateinit var map: GoogleMap
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

        setViweListeners()
        startLocationService()
        vm.locateFlow.collectWithLifecycle(this, ::handleLocate)
        vm.exceptionFlow.collectWithLifecycle(this, ::handleException)
    }

    private fun setViweListeners() {
        binding.btnOpenDrawer.setOnClickListener {
            binding.dlContainer.open()
        }

        binding.tvGuide.setOnClickListener {
            startActivity(Intent(this, GuideActivity::class.java))
        }

        binding.tvContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        binding.tvInformation.setOnClickListener {
            startActivity(Intent(this, InformationActivitty::class.java))
        }

        binding.bnvNavigation.setOnItemSelectedListener { menu ->
            if (::map.isInitialized) {
                val placeType = when (menu.itemId) {
                    R.id.navigatin_flood_damage -> PlaceType.FLOOD_DAMAGE
                    R.id.navigation_volcano -> PlaceType.VOLCANO
                    R.id.navgation_earthquake -> PlaceType.EARTHQUAKE
                    R.id.navigation_heat_wave -> PlaceType.HEAT_WAVE
                    else -> throw Exception("Unknown menu: ${menu.title}")
                }
                map.clear()
                vm.findPlace(placeType, lastLocate)
            }
            true
        }

        binding.bnvNavigation.setOnItemReselectedListener {}
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
                    vm.findPlace(type = PlaceType.FLOOD_DAMAGE, locate = lastLocate)
                }
            }
            result.error?.let { exception ->
                logeukes(type = LoggerType.E) { exception }
            }
        }
    }

    private fun marking(place: PlaceFindResult) {
        if (::map.isInitialized) {
            map.addMarker(
                MarkerOptions()
                    .position(place.locate)
                    .title(place.name)
                    .snippet(place.address)
            )
        }
    }

    private fun moveCameraAndZoom(locate: LatLng) {
        if (::map.isInitialized) {
            // max: 21f
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(locate, 18f))
        }
    }

    private fun handleException(throwable: Throwable) {
        val message = when (BuildConfig.DEBUG) {
            true -> throwable.message.toString()
            else -> getString(R.string.activity_map_toast_occur_exception)
        }
        toast(message)
    }

    private fun handleLocate(locates: List<PlaceFindResult>) {
        if (locates.isEmpty()) {
            toast(getString(R.string.activity_map_toast_none_shelper))
        } else {
            if (!firstRequest) {
                moveCameraAndZoom(locates.first().locate)
            } else {
                firstRequest = false
            }
            locates.forEach(::marking)
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
