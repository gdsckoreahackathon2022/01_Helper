/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [PhotosItem.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:55
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PhotosItem(
    @field:JsonProperty("photo_reference")
    val photoReference: String? = null,

    @field:JsonProperty("width")
    val width: Int? = null,

    @field:JsonProperty("html_attributions")
    val htmlAttributions: List<String?>? = null,

    @field:JsonProperty("height")
    val height: Int? = null,
)
