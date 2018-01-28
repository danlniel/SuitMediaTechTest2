package com.suit.techtest1.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.location.places.Place
import com.suit.techtest1.Extension.ctx
import com.suit.techtest1.Extension.openCachingImage
import com.suit.techtest1.R

/**
 * Created by Daniel on 1/28/2018.
 */

class ImageFragment: Fragment() {
    companion object {
        fun newInstance(place: Place): ImageFragment {
            val imageFrag = ImageFragment()
            imageFrag.place = place
            return imageFrag
        }
    }
    lateinit var place: Place
    lateinit var imageView: ImageView
    lateinit var labelEvent: TextView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.pager_item_view, container, false)
        setupView(view)
        return view
    }

    fun setupView(view: View?) {
        labelEvent = view!!.findViewById(R.id.labelEvent)
        imageView = view!!.findViewById(R.id.imageView)
        imageView.openCachingImage(view.ctx, "https://static.boredpanda.com/blog/wp-content/uuuploads/landscape-photography/landscape-photography-41.jpg")
        labelEvent.setText(place.id)
    }
}