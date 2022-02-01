/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ShelperApp.kt] created by Ji Sungbin on 22. 1. 23. 오후 8:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper

import android.app.Application
import android.content.Intent
import dagger.hilt.android.HiltAndroidApp
import io.github.jisungbin.erratum.Erratum
import io.github.jisungbin.erratum.ErratumExceptionActivity
import io.github.jisungbin.logeukes.Logeukes
import team.gdsc.shelper.activity.error.ErrorActivity
import team.gdsc.shelper.util.constant.IntentConstant

@HiltAndroidApp
class ShelperApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Erratum.setup(
            application = this,
            registerExceptionActivityIntent = { _, throwable, lastActivity ->
                Intent(lastActivity, ErrorActivity::class.java).apply {
                    putExtra(ErratumExceptionActivity.EXTRA_EXCEPTION_STRING, throwable.toString())
                    putExtra(
                        ErratumExceptionActivity.EXTRA_LAST_ACTIVITY_INTENT,
                        lastActivity.intent
                    )
                    putExtra(IntentConstant.Error, IntentConstant.Exception)
                }
            }
        )
        if (BuildConfig.DEBUG) {
            Logeukes.setup()
        }
    }
}
