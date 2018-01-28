package com.suit.techtest1.Extension

import android.app.Activity
import android.app.AlertDialog
import android.content.Context

/**
 * Created by Daniel on 1/27/2018.
 */
fun Activity.showAlertDialog(context: Context, dialogBuilder: AlertDialog.Builder.() -> Unit) {
    val builder = AlertDialog.Builder(context)
    builder.dialogBuilder()
    val dialog = builder.create()

    dialog.show()
}

fun AlertDialog.Builder.positiveButton(text: String = "Okay", handleClick: (which: Int) -> Unit = {}) {
    this.setPositiveButton(text, { dialogInterface, which-> handleClick(which) })
}

fun AlertDialog.Builder.negativeButton(text: String = "Cancel", handleClick: (which: Int) -> Unit = {}) {
    this.setNegativeButton(text, { dialogInterface, which-> handleClick(which) })
}