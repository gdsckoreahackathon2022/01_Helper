/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [SearchInfo.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:04
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.model.domain

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class SearchInfo(
    val pageUnit: String = "15",
    val pageSize: String = "1",
    val pageIndex: String = "1",
    val firstIndex: String = "1",
    val lastIndex: String = "1",
    val searchEndDe: String = getToday(),
    val searchBgnDe: String = searchEndDe,
    val recordCountPerPage: String = pageUnit,
)

private fun getToday() = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date())
