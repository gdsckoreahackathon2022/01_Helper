/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [OpeningHours.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:55
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OpeningHours(
    @field:JsonProperty("open_now")
    val openNow: Boolean? = null,
)
