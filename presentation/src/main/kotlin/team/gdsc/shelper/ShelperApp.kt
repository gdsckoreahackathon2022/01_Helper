package team.gdsc.shelper

import android.app.Application
import android.content.Intent
import dagger.hilt.android.HiltAndroidApp
import io.github.jisungbin.erratum.Erratum
import io.github.jisungbin.erratum.ErratumExceptionActivity
import style.carrot.android.util.constant.IntentConstant
import team.gdsc.shelper.activity.error.ErrorActivity

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
        /*if (BuildConfig.DEBUG) {
            Logeukes.setup()
        }*/
    }
}
