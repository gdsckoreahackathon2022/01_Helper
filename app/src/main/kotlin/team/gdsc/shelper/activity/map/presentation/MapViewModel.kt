/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MapViewModel.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import team.gdsc.shelper.activity.map.datasource.PlaceFindDataSource
import javax.inject.Inject
import team.gdsc.shelper.activity.map.enum.PlaceType

@HiltViewModel
class MapViewModel @Inject constructor(
    private val placeFindDataSource: PlaceFindDataSource,
) : ViewModel() {
    fun findPlace(type: PlaceType) {

    }
}
