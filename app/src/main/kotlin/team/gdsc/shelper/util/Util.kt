/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [Util.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:22
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Util {
    fun getInterceptor(vararg interceptors: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        for (interceptor in interceptors) builder.addInterceptor(interceptor)
        return builder.build()
    }

    fun getToday() = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date())
}
