package com.suit.techtest1.Extension

import android.app.Activity
import android.content.Context
import android.widget.Toast

/**
 * Created by Daniel on 1/27/2018.
 */
fun Activity.showToast(msg: String, toastDuration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, toastDuration).show()
}
