/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [SystemUiControllerExtension.kt] created by Ji Sungbin on 22. 1. 29. 오후 9:43
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util.systemuicontroller

import android.app.Activity
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment

fun Fragment.setStatusBarColor(
    @ColorInt color: Int,
    darkIcons: Boolean = false,
) {
    SystemUiController(requireActivity().window).setStatusBarColor(
        color = color,
        darkIcons = darkIcons
    )
}

fun Activity.setStatusBarColor(
    @ColorInt color: Int,
    darkIcons: Boolean = false,
) {
    SystemUiController(window).setStatusBarColor(color = color, darkIcons = darkIcons)
}

fun Fragment.setNavigationBarColor(
    @ColorInt color: Int,
    darkIcons: Boolean = false,
) {
    SystemUiController(requireActivity().window).setNavigationBarColor(
        color = color,
        darkIcons = darkIcons
    )
}

fun Activity.setNavigationBarColor(
    @ColorInt color: Int,
    darkIcons: Boolean = false,
) {
    SystemUiController(window).setNavigationBarColor(color = color, darkIcons = darkIcons)
}

fun Fragment.setSystemBarsColor(
    @ColorInt color: Int,
    darkIcons: Boolean = false,
) {
    SystemUiController(requireActivity().window).setSystemBarsColor(
        color = color,
        darkIcons = darkIcons
    )
}

fun Activity.setSystemBarsColor(
    @ColorInt color: Int,
    darkIcons: Boolean = false,
) {
    SystemUiController(window).setSystemBarsColor(color = color, darkIcons = darkIcons)
}
