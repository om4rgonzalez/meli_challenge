package net.omar.gonzalez.meli.core.extensions

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    url: String,
    context: Context,
    @DrawableRes placeholder: Int,
    @DrawableRes onError: Int = placeholder
) {
    Glide.with(context)
        .load(url)
        .fitCenter()
        .error(onError)
        .placeholder(placeholder)
        .skipMemoryCache(true)
        .into(this)
}