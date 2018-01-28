package com.suit.techtest1.Listener

import com.google.android.gms.location.places.Place

/**
 * Created by Daniel on 1/28/2018.
 */

interface CustomLocationListener {
    fun locationCallback(place: Place)
}