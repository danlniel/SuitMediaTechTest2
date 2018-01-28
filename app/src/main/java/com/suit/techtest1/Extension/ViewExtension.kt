package com.suit.techtest1.Extension

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by Daniel on 1/27/2018.
 */
    val View.ctx: Context
        get() = context

    var TextView.textColor: Int
        get() = currentTextColor
        set(v) = setTextColor(v)

    fun View.setSize(width: Int, height: Int) {
        val layoutParams = this.getLayoutParams()
        layoutParams.height = height
        layoutParams.width = width
        this.setLayoutParams(layoutParams)
    }

    fun View?.isNull(): Boolean {
        return this == null
    }