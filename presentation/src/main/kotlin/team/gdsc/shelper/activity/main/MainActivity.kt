/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MainActivity.kt] created by Ji Sungbin on 22. 1. 23. 오후 8:58
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.main

// import team.gdsc.shelper.util.systemuicontroller.SystemUiController
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import dagger.hilt.android.AndroidEntryPoint
import team.gdsc.shelper.R
import team.gdsc.shelper.activity.error.ErrorActivity
import team.gdsc.shelper.util.NetworkUtil
import team.gdsc.shelper.util.constant.IntentConstant

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnMapReadyCallback {

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

        WindowCompat.setDecorFitsSystemWindows(window, false)
        // SystemUiController(window).setSystemBarsColor(Color.TRANSPARENT)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
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
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }
}
