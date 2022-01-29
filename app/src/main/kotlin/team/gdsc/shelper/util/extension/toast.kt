/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [toast.kt] created by Ji Sungbin on 22. 1. 29. 오후 11:23
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util.extension

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun toast(context: Context, message: String, length: Int) {
    Toast.makeText(context, message, length).show()
}

fun toast(activity: Activity, message: String, length: Int) {
    activity.runOnUiThread {
        Toast.makeText(activity, message, length).show()
    }
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    toast(requireActivity(), message, length)
}

@JvmName("ActivityToastExtension")
fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    toast(this, message, length)
}
