/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [PlaceType.kt] created by Ji Sungbin on 22. 1. 30. 오후 4:32
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.constant

enum class PlaceType(val query: String, val isType: Boolean = true) {
    FLOOD_DAMAGE("mountain", false),
    VOLCANO("school"),
    EARTHQUAKE("park"),
    HEAT_WAVE("cafe")
}
