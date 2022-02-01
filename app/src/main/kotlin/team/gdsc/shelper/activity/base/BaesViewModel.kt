/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [BaesViewModel.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:50
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaesViewModel<ITEM> : ViewModel() {
    private val _exceptionFlow = MutableSharedFlow<Throwable>()
    val exceptionFlow = _exceptionFlow.asSharedFlow()

    private val _itemFlow = MutableSharedFlow<ITEM>()
    val itemFlow = _itemFlow.asSharedFlow()
}
