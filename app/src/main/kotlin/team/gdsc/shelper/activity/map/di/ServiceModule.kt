/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [RetrofitModule.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import team.gdsc.shelper.activity.map.datasource.PlaceFindApi
import team.gdsc.shelper.util.Util
import team.gdsc.shelper.util.constant.Api

@Module
@InstallIn(ViewModelComponent::class)
object ServiceModule {
    @Provides
    @ViewModelScoped
    fun providePlaceFindApi(
        loggingInterceptor: HttpLoggingInterceptor,
        jackson: JacksonConverterFactory,
    ): PlaceFindApi = Retrofit.Builder()
        .baseUrl(Api.GoogleMap)
        .addConverterFactory(jackson)
        .client(Util.getInterceptor(loggingInterceptor))
        .build()
        .create(PlaceFindApi::class.java)
}
