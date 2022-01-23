/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [NetworkUtil.kt] created by Ji Sungbin on 22. 1. 23. 오후 8:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkUtil {
    fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            getNetworkCapabilities(activeNetwork)?.run {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        }
}
