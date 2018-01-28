package com.suit.techtest1.Extension

/**
 * Created by Daniel on 1/27/2018.
 */

fun Int.isZero(): Boolean {
    return this == 0
}

fun Int.isPrime(): Boolean {
    for (p in 2 until this) {
        if (this % p == 0) {
            return false
        }
    }
    return true
}