package com.suit.techtest1.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.location.places.Place
import com.suit.techtest1.Extension.ctx
import com.suit.techtest1.Extension.openCachingImage
import com.suit.techtest1.Extension.setSize
import com.suit.techtest1.R
import kotlinx.android.synthetic.main.recyclerview_top_map.view.*

/**
 * Created by Daniel on 1/28/2018.
 */

class RecyclerTopDetailMapAdapter(val listPlace: ArrayList<Place>,
                                  val itemClick: (Place) -> Unit) :
        RecyclerView.Adapter<RecyclerTopDetailMapAdapter.ViewHolder>() {

    var mlistPlace = listPlace
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.recyclerview_top_map, parent, false)
        view.setSize((parent.width*0.65).toInt(), parent.height)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(mlistPlace[position])
    }

    override fun getItemCount() = mlistPlace.size

    fun refreshData(listPlace: ArrayList<Place>) {
        mlistPlace = listPlace
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, val itemClick: (Place) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindForecast(place: Place) {
            with(place) {
                itemView.imageView.openCachingImage(itemView.ctx, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Pantheon_%288350771972%29.jpg/440px-Pantheon_%288350771972%29.jpg")
                itemView.setOnClickListener() { itemClick(this) }
            }
        }
    }
}
