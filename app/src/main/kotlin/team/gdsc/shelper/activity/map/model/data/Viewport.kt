/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [Viewport.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:55
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Viewport(
    @field:JsonProperty("southwest")
    val southwest: Southwest? = null,

    @field:JsonProperty("northeast")
    val northeast: Northeast? = null,
)
