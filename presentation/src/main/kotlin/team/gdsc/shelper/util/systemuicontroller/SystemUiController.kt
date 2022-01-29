/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [SystemUiController.kt] created by Ji Sungbin on 22. 1. 29. 오후 9:43
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util.systemuicontroller

import android.os.Build
import android.view.View
import android.view.Window
import androidx.annotation.ColorInt

@Suppress("DEPRECATION", "MemberVisibilityCanBePrivate")
class SystemUiController(private val window: Window) {
    fun setStatusBarColor(
        color: Int,
        darkIcons: Boolean = false,
    ) {
        window.statusBarColor = color
        if (darkIcons) {
            window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
        }
    }

    fun setNavigationBarColor(
        @ColorInt color: Int,
        darkIcons: Boolean = false,
    ) {
        window.navigationBarColor = color
        if (Build.VERSION.SDK_INT >= 26) {
            if (darkIcons) {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and
                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
            }
        }
    }

    fun setSystemBarsColor(
        @ColorInt color: Int,
        darkIcons: Boolean = false,
    ) {
        setStatusBarColor(color, darkIcons)
        setNavigationBarColor(color, darkIcons)
    }
}
