package com.suit.techtest1.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suit.techtest1.Extension.ctx
import com.suit.techtest1.Extension.openCachingImage
import com.suit.techtest1.Model.Event
import com.suit.techtest1.R
import com.suit.techtest1.Utils.Utils
import kotlinx.android.synthetic.main.recyclerview_event.view.*

/**
 * Created by Daniel on 1/27/2018.
 */

class RecyclerViewAdapter(val listEvent: ArrayList<Event>,
                          val itemClick: (Event) -> Unit) :
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var mListEvent = listEvent

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.recyclerview_event, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(mListEvent[position])
    }

    override fun getItemCount() = mListEvent.size

    class ViewHolder(itemView: View, val itemClick: (Event) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindForecast(event: Event) {
            with(event) {
                itemView.eventImageView.openCachingImage(itemView.ctx, this.imageUrl)
                itemView.txtEvent.setText(this.name)
                itemView.txtDate.setText(Utils.formatter().format(this.date))
                itemView.setOnClickListener() { itemClick(this) }
            }
        }
    }
}
