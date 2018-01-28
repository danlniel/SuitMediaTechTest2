package com.suit.techtest1.Helper

/**
 * Created by Daniel on 1/27/2018.
 */

class Constant {
    companion object {
        val LOCATION_PERMISSION_REQUEST_CODE = 1
        val PLACE_PICKER_REQUEST = 3
        var EVENT_PRIMAR_KEY: Int = -1

        val GRID_SPACING = 10

        fun getPk(): Int {
            EVENT_PRIMAR_KEY++
            return EVENT_PRIMAR_KEY
        }
    }
}
