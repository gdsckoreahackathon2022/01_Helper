/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [PlaceFindDataSource.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:59
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.datasource

import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.scopes.ViewModelScoped
import team.gdsc.shelper.activity.map.enum.PlaceType
import team.gdsc.shelper.activity.map.enum.ResponseStatus
import team.gdsc.shelper.activity.map.model.domain.PlaceFindResult
import team.gdsc.shelper.util.extension.isValid
import team.gdsc.shelper.util.extension.toException
import javax.inject.Inject

@ViewModelScoped
class PlaceFindDataSource @Inject constructor(private val api: PlaceFindApi) {
    suspend operator fun invoke(placeType: PlaceType, location: LatLng) = runCatching {
        val locationString = "${location.latitude},${location.longitude}"
        val request = when (placeType.isType) {
            true -> api.searchWithType(query = placeType.query, location = locationString)
            else -> api.search(query = placeType.query, location = locationString)
        }
        if (request.isValid()) {
            val response = request.body()!!
            when (val status = response.status) {
                ResponseStatus.OK.string -> {
                    response.results!!.map { place ->
                        val locate = place!!.geometry!!.location!!
                        PlaceFindResult(
                            locate = LatLng(locate.lat!!, locate.lng!!),
                            name = place.name!!,
                            address = place.formattedAddress!!
                        )
                    }
                }
                else -> throw Exception("ResponseStatus is not OK.\nstatus: $status")
            }
        } else {
            throw request.toException()
        }
    }
}
