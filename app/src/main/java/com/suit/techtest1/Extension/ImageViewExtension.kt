package com.suit.techtest1.Extension

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Daniel on 1/27/2018.
 */
fun ImageView.openCachingImage(context: Context, url: String) {
    Glide.with(context).load(url).into(this)
}