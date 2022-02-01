/*
 * Shelper © 2022 Team Helper. all rights reserved.
 * Shelper license is under the MIT.
 *
 * [ImageBinding.kt] created by Ji Sungbin on 22. 1. 30. 오후 3:56
 *
 * Please see: https://github.com/gdsckoreahackathon2022/01_Helper/blob/main/LICENSE.
 */

package team.gdsc.shelper.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import team.gdsc.shelper.GlideApp

@BindingAdapter("srcAny")
fun src(imageView: ImageView, any: Any) {
    GlideApp.with(imageView.context).load(any).into(imageView)
}
