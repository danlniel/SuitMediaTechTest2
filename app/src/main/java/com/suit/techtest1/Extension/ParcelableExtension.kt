package com.suit.techtest1.Extension

import android.os.Parcelable

/**
 * Created by Daniel on 1/27/2018.
 */

fun Parcelable.isNull(): Boolean {
    return this == null
}