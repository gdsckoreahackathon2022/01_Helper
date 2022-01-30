/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ResponseStatus.kt] created by Ji Sungbin on 22. 1. 30. 오후 5:20
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.constant

@Suppress("unused")
enum class ResponseStatus(val string: String) {
    OK("OK"),
    ZERO_RESULTS("ZERO_RESULTS"),
    INVALID_REQUEST("INVALID_REQUEST"),
    OVER_QUERY_LIMIT("OVER_QUERY_LIMIT"),
    REQUEST_DENIED("REQUEST_DENIED"),
    UNKNOWN_ERROR("UNKNOWN_ERROR")
}
