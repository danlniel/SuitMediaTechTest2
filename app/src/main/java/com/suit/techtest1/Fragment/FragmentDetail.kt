package com.suit.techtest1.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.places.Place
import com.suit.techtest1.Adapter.ImagePagerAdapter
import com.suit.techtest1.Listener.CustomLocationListener
import com.suit.techtest1.R

/**
 * Created by Daniel on 1/28/2018.
 */

class FragmentDetail: Fragment(), CustomLocationListener {
    lateinit var fragMap: FragmentMap
    var listPlace = arrayListOf<Place>()
    val adapter by lazy {
        ImagePagerAdapter(childFragmentManager, listPlace)
    }

    lateinit var mViewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_detail_view, container, false)
        setViewPager(view)
        getFragMap()
        return view
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    override fun locationCallback(place: Place) {

    }

    fun setViewPager(view: View?) {
        mViewPager = view!!.findViewById(R.id.viewPager)
        mViewPager.adapter = adapter
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                pointCameraTo(listPlace[position])
            }
        })
    }

    fun addPlace(place: Place) {
        listPlace.add(place)
        adapter.refreshData(listPlace)
        fragMap.placeMarkerOnMap(place)
    }

    fun refreshList() {
        adapter.refreshData(listPlace)
    }

    fun pointCameraTo(place: Place) {
        fragMap.goToLocation(place.latLng.latitude, place.latLng.longitude)
    }

    fun getFragMap() {
        fragMap = childFragmentManager.findFragmentById(R.id.fragment_detail_map) as FragmentMap
        fragMap.setListener(this)
    }
}
