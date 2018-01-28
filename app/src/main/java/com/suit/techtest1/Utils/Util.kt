package com.suit.techtest1.Utils

import android.os.Build
import android.support.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

/**
 * Created by Daniel on 1/27/2018.
 */

class Utils {
    companion object {
        fun isNull(target: Any?): Boolean {
            return target == null
        }

        fun formatter(): SimpleDateFormat {
            val formatter = SimpleDateFormat("dd MM yyyy", Locale.US)
            return formatter
        }

        fun createDate(dd: String, mm: String, yyyy: String): Date {
            return Utils.formatter().parse("$dd $mm $yyyy")
        }
    }
}