/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MessageViewModel.kt] created by Ji Sungbin on 22. 2. 1. 오후 8:50
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jisungbin.logeukes.logeukes
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import team.gdsc.shelper.activity.message.DataStore
import team.gdsc.shelper.activity.message.datasource.MessageRequestDataSource
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val messageRequestDataSource: MessageRequestDataSource,
) : ViewModel() {

    private val _exceptionFlow = MutableSharedFlow<Throwable>()
    val exceptionFlow = _exceptionFlow.asSharedFlow()

    private val _messageFlow = MutableSharedFlow<List<String>>()
    val messageFlow = _messageFlow.asSharedFlow()

    fun request() = viewModelScope.launch {
        logeukes { "request" }
        if (DataStore.messages.isEmpty()) {
            messageRequestDataSource()
                .onSuccess { messages ->
                    logeukes { messages }
                    DataStore.messages = messages
                    _messageFlow.emit(messages)
                }
                .onFailure { exception ->
                    logeukes { exception }
                    _exceptionFlow.emit(exception)
                }
        } else {
            _messageFlow.emit(DataStore.messages)
        }
    }
}
