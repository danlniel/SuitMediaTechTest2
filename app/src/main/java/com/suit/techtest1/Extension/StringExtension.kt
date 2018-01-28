package com.suit.techtest1.Extension

/**
 * Created by Daniel on 1/27/2018.
 */

fun String.isPalindrome(): Boolean {
    val withoutSapce = this.replace("\\s".toRegex(), "")
    val reversed = withoutSapce.reversed()
    return withoutSapce == reversed
}