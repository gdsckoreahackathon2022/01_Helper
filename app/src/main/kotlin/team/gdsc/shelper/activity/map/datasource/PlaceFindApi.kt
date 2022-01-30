/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [PlaceFindApi.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:59
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.datasource

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import team.gdsc.shelper.BuildConfig
import team.gdsc.shelper.activity.map.model.data.PlaceFindResponse

interface PlaceFindApi {
    @GET("maps/api/place/textsearch/json")
    suspend fun search(
        @Query("language") language: String = "ko",
        @Query("radius") radius: Int = 2000,
        @Query("region") region: String = "kr",
        @Query("location") location: String,
        @Query("query") query: String,
        @Query("key") key: String = BuildConfig.MAPS_API_KEY,
    ): Response<PlaceFindResponse>

    @GET("maps/api/place/textsearch/json")
    suspend fun searchWithType(
        @Query("language") language: String = "ko",
        @Query("radius") radius: Int = 2000,
        @Query("region") region: String = "kr",
        @Query("location") location: String,
        @Query("query") query: String,
        @Query("type") type: String = query,
        @Query("key") key: String = BuildConfig.MAPS_API_KEY,
    ): Response<PlaceFindResponse>
}
