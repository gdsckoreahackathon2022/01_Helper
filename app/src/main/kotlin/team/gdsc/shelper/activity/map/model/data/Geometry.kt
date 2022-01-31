/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [Geometry.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:54
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model.data

import com.fasterxml.jackson.annotation.JsonProperty

data class Geometry(
    @field:JsonProperty("viewport")
    val viewport: Viewport? = null,

    @field:JsonProperty("location")
    val location: Location? = null,
)
