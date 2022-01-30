/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [Flow.kt] created by Ji Sungbin on 22. 1. 30. 오후 5:49
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.collectWithLifecycle(
    lifecycleOwner: LifecycleOwner,
    action: suspend (T) -> Unit,
) {
    lifecycleOwner.lifecycleScope.launchWhenCreated {
        flowWithLifecycle(lifecycleOwner.lifecycle).collect { value ->
            action(value)
        }
    }
}
