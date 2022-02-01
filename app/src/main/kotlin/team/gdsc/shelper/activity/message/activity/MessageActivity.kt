/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [MessageActivity.kt] created by Ji Sungbin on 22. 2. 1. 오후 9:34
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.message.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import io.github.jisungbin.logeukes.logeukes
import team.gdsc.shelper.BuildConfig
import team.gdsc.shelper.R
import team.gdsc.shelper.databinding.ActivityMessageBinding
import team.gdsc.shelper.util.extension.collectWithLifecycle
import team.gdsc.shelper.util.extension.toast

@AndroidEntryPoint
class MessageActivity : AppCompatActivity() {

    private val vm: MessageViewModel by viewModels()
    private lateinit var binding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message)

        vm.messageFlow.collectWithLifecycle(this, ::handleMessage)
        vm.exceptionFlow.collectWithLifecycle(this, ::handleException)
        vm.request()
    }

    private fun handleException(throwable: Throwable) {
        val message = when (BuildConfig.DEBUG) {
            true -> throwable.message.toString()
            else -> getString(R.string.activity_map_toast_occur_exception)
        }
        toast(message)
    }

    private fun handleMessage(messages: List<String>) {
        logeukes { messages }
        binding.rvMessage.apply {
            setHasFixedSize(true)
            adapter = MessageAdapter(messages).apply {
                setHasStableIds(true)
            }
        }
    }
}
