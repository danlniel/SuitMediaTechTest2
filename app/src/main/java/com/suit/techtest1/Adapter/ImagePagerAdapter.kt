package com.suit.techtest1.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.google.android.gms.location.places.Place
import com.suit.techtest1.Fragment.ImageFragment

/**
 * Created by Daniel on 1/28/2018.
 */

class ImagePagerAdapter(fragmentManager: FragmentManager, val listPlace: ArrayList<Place>) :
        FragmentStatePagerAdapter(fragmentManager) {

    var mListPlace = listPlace
    override fun getItem(position: Int): Fragment {
        return ImageFragment.newInstance(mListPlace[position])
    }

    override fun getCount(): Int {
        return mListPlace.size
    }

    fun addhData(place: Place) {
        mListPlace.add(place)
        notifyDataSetChanged()
    }

    fun refreshData(listPlace: ArrayList<Place>) {
        mListPlace = listPlace
        notifyDataSetChanged()
    }
}