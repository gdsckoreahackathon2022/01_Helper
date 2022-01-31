/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [RetrofitModule.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.map.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.github.jisungbin.logeukes.logeukes
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import team.gdsc.shelper.activity.map.datasource.PlaceFindApi
import team.gdsc.shelper.util.constant.Api

@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {
    private val loggingInterceptor =
        HttpLoggingInterceptor { message -> logeukes("OkHttp") { message } }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val mapper = ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
        .registerKotlinModule()

    private fun getInterceptor(vararg interceptors: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        for (interceptor in interceptors) builder.addInterceptor(interceptor)
        return builder.build()
    }

    @Provides
    @ViewModelScoped
    fun providePlaceFindApi(): PlaceFindApi = Retrofit.Builder()
        .baseUrl(Api.GoogleMap)
        .addConverterFactory(JacksonConverterFactory.create(mapper))
        .client(getInterceptor(loggingInterceptor))
        .build()
        .create(PlaceFindApi::class.java)
}
