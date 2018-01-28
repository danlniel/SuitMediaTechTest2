package com.suit.techtest1.Fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.Place
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.ui.IconGenerator
import com.suit.techtest1.Extension.askPermissionMap
import com.suit.techtest1.Listener.CustomLocationListener
import com.suit.techtest1.R

/**
 * Created by Daniel on 1/28/2018.
 */

class FragmentMap: Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    lateinit var onLocationAdd: () -> Unit

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater?.inflate(R.layout.fragment_map_view, container, false)
        val mapFragment = getChildFragmentManager().findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        return v
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        setupGoogleMap()

        activity.askPermissionMap()
    }

    override fun onMarkerClick(p0: Marker?): Boolean = true


    //Mark: - Location Listener
    var callbackLocation: CustomLocationListener? = null
    fun setListener(listener: CustomLocationListener) {
        callbackLocation = listener
    }

    fun placeMarkerOnMap(place: Place) {
        val iconFactory = IconGenerator(activity)
        val markerOptions = MarkerOptions().
                icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(place.id))).
                position(place.latLng).anchor(iconFactory.anchorU, iconFactory.anchorV)
        mMap.addMarker(markerOptions)
    }

    public fun goToLocation(lat: Double, long: Double) {
        val currentLatLng = LatLng(lat, long)
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
    }

    fun setupGoogleMap() {
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)
        mMap.isMyLocationEnabled = true
        if (ActivityCompat.checkSelfPermission(activity,
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.isMyLocationEnabled = true
        }

        fusedLocationClient.lastLocation.addOnSuccessListener(activity) { location ->
            if (location != null) {
                goToLocation(location.latitude, location.longitude)
            }
        }
    }
}