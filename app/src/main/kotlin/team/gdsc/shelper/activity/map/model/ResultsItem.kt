/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ResultsItem.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:55
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ResultsItem(
    @field:JsonProperty("formatted_address")
    val formattedAddress: String? = null,

    @field:JsonProperty("types")
    val types: List<String?>? = null,

    @field:JsonProperty("business_status")
    val businessStatus: String? = null,

    @field:JsonProperty("icon")
    val icon: String? = null,

    @field:JsonProperty("rating")
    val rating: Double? = null,

    @field:JsonProperty("icon_background_color")
    val iconBackgroundColor: String? = null,

    @field:JsonProperty("photos")
    val photos: List<PhotosItem?>? = null,

    @field:JsonProperty("reference")
    val reference: String? = null,

    @field:JsonProperty("user_ratings_total")
    val userRatingsTotal: Int? = null,

    @field:JsonProperty("price_level")
    val priceLevel: Int? = null,

    @field:JsonProperty("name")
    val name: String? = null,

    @field:JsonProperty("opening_hours")
    val openingHours: OpeningHours? = null,

    @field:JsonProperty("geometry")
    val geometry: Geometry? = null,

    @field:JsonProperty("icon_mask_base_uri")
    val iconMaskBaseUri: String? = null,

    @field:JsonProperty("plus_code")
    val plusCode: PlusCode? = null,

    @field:JsonProperty("place_id")
    val placeId: String? = null,

    @field:JsonProperty("permanently_closed")
    val permanentlyClosed: Boolean? = null,
)
