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
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import team.gdsc.shelper.activity.map.datasource.PlaceFindDataSource
import team.gdsc.shelper.activity.map.constant.PlaceType
import team.gdsc.shelper.activity.map.model.domain.PlaceFindResult
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val placeFindDataSource: PlaceFindDataSource,
) : ViewModel() {

    private val locationCaching = hashMapOf<PlaceType, List<PlaceFindResult>>()

    private val _exceptionFlow = MutableSharedFlow<Throwable>()
    val exceptionFlow = _exceptionFlow.asSharedFlow()

    private val _locateFlow = MutableSharedFlow<List<PlaceFindResult>>()
    val locateFlow = _locateFlow.asSharedFlow()

    fun findPlace(type: PlaceType, locate: LatLng) = viewModelScope.launch {
        if (locationCaching[type] == null) {
            placeFindDataSource(type, locate)
                .onSuccess { response ->
                    locationCaching[type] = response
                    _locateFlow.emit(response)
                }
                .onFailure { exception ->
                    _exceptionFlow.emit(exception)
                }
        } else {
            _locateFlow.emit(locationCaching[type]!!)
        }
    }
}
