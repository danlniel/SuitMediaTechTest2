package com.suit.techtest1.Extension

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.location.places.ui.PlacePicker
import com.suit.techtest1.Helper.Constant.Companion.LOCATION_PERMISSION_REQUEST_CODE
import com.suit.techtest1.Helper.Constant.Companion.PLACE_PICKER_REQUEST

/**
 * Created by Daniel on 1/28/2018.
 */

fun Activity.askPermissionMap() {
    if (ActivityCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
    }
}

fun Activity.loadPlacePicker() {
    val builder = PlacePicker.IntentBuilder()
    try {
        startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST)
    } catch (e: GooglePlayServicesRepairableException) {
        e.printStackTrace()
    } catch (e: GooglePlayServicesNotAvailableException) {
        e.printStackTrace()
    }
}