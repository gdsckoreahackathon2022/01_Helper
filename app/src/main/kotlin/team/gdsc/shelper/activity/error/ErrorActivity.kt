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
import androidx.core.view.WindowCompat
import io.github.jisungbin.erratum.ErratumExceptionActivity

class ErrorActivity : ErratumExceptionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    /*
    when (intent.getStringExtra(IntentConstant.Error)) {
            IntentConstant.NoInternet -> {
                message = stringResource(R.string.activity_error_internet)
                lottieRaw = R.raw.no_internet
            }
            else -> {
                lottieRaw = R.raw.rabbit
                message = when (BuildConfig.DEBUG) {
                    true -> exceptionString!!
                    else -> stringResource(R.string.activity_error_exception)
                }
            }
        }
     */
}
