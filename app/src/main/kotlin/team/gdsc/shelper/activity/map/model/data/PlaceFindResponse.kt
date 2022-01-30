/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [PlaceFindResponse.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:55
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PlaceFindResponse(
    @field:JsonProperty("next_page_token")
    val nextPageToken: String? = null,

    @field:JsonProperty("html_attributions")
    val htmlAttributions: List<Any?>? = null,

    @field:JsonProperty("results")
    val results: List<ResultsItem?>? = null,

    @field:JsonProperty("status")
    val status: String? = null,
)
