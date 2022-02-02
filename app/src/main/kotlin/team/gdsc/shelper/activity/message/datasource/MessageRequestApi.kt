/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [RequestApi.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:11
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.datasource

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import team.gdsc.shelper.activity.message.model.data.MessageRequestResponse
import team.gdsc.shelper.activity.message.model.domain.MessageRequestBody

interface MessageRequestApi {
    @POST("idsiSFK/sfk/cs/sua/web/DisasterSmsList.do")
    suspend fun request(@Body body: MessageRequestBody = MessageRequestBody()): Response<MessageRequestResponse>
}
