/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [PlaceFindResult.kt] created by Ji Sungbin on 22. 1. 30. 오후 4:26
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.model.domain

import com.google.android.gms.maps.model.LatLng

data class PlaceFindResult(val locate: LatLng, val name: String, val address: String)
