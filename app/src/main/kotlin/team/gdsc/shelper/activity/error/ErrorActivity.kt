/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ErrorActivity.kt] created by Ji Sungbin on 22. 1. 23. 오후 8:57
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.activity.error

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.github.jisungbin.erratum.ErratumExceptionActivity
import team.gdsc.shelper.BuildConfig
import team.gdsc.shelper.R
import team.gdsc.shelper.databinding.ActivityErrorBinding
import team.gdsc.shelper.util.constant.IntentConstant

class ErrorActivity : ErratumExceptionActivity() {

    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_error)
        actionBar?.hide()

        val message = when (intent.getStringExtra(IntentConstant.Error)) {
            IntentConstant.NoInternet -> {
                getString(R.string.activity_error_no_internet)
            }
            else -> {
                when (BuildConfig.DEBUG) {
                    true -> exceptionString!!
                    else -> getString(R.string.activity_error_exception)
                }
            }
        }
        binding.tvMessage.text = message

        binding.btnRetry.setOnClickListener {
            openLastActivity()
        }
    }
}
