/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [runIf.kt] created by Ji Sungbin on 22. 1. 29. 오후 10:08
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.util.extension

inline fun <T> T.runIf(condition: Boolean, run: T.() -> T) = if (condition) {
    run()
} else this
