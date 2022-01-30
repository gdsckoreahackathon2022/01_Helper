/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [Response.kt] created by Ji Sungbin on 22. 1. 30. 오후 4:08
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util.extension

import retrofit2.Response

fun <T> Response<T>.isValid() = isSuccessful && body() != null

fun <T> Response<T>.toException() = Exception(errorBody()?.use { it.string() })
