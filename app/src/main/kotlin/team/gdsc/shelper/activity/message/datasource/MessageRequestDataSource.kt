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
import javax.inject.Inject

@ViewModelScoped
class MessageRequestDataSource @Inject constructor(private val api: MessageRequestApi) {
    suspend operator fun invoke() {
        val request = api.request()
    }
}
