package team.gdsc.shelper.activity.guide.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import team.gdsc.shelper.GlideApp

@BindingAdapter("srcAny")
fun src(imageView: ImageView, any: Any) {
    GlideApp.with(imageView.context).load(any).into(imageView)
}
