/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [RtnResult.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:13
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.model.data

import com.fasterxml.jackson.annotation.JsonProperty

data class RtnResult(
    @field:JsonProperty("totCnt")
    val totCnt: Int? = null,

    @field:JsonProperty("resultCode")
    val resultCode: String? = null,

    @field:JsonProperty("pageSize")
    val pageSize: Int? = null,

    @field:JsonProperty("resultMsg")
    val resultMsg: String? = null,
)
