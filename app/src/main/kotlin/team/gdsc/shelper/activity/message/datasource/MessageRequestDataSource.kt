/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MessageRequestDataSource.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:25
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.datasource

import dagger.hilt.android.scopes.ViewModelScoped
import team.gdsc.shelper.util.extension.isValid
import team.gdsc.shelper.util.extension.toException
import javax.inject.Inject

@ViewModelScoped
class MessageRequestDataSource @Inject constructor(private val api: MessageRequestApi) {
    suspend operator fun invoke() = runCatching {
        val request = api.request()
        if (request.isValid()) {
            request.body()!!.disasterSmsList.map { message -> message?.msgCn }
        } else {
            throw request.toException()
        }
    }
}
