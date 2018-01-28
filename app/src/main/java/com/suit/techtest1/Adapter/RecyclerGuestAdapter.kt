package com.suit.techtest1.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.suit.techtest1.Extension.ctx
import com.suit.techtest1.Extension.setSize
import com.suit.techtest1.Helper.Constant.Companion.GRID_SPACING
import com.suit.techtest1.Model.Person
import com.suit.techtest1.R
import kotlinx.android.synthetic.main.recyclerview_guest.view.*


/**
 * Created by Daniel on 1/27/2018.
 */

class RecyclerGuestAdapter(val listPerson: ArrayList<Person>,
                    val itemClick: (Person) -> Unit) :
        RecyclerView.Adapter<RecyclerGuestAdapter.ViewHolder>() {

    var mListPerson = listPerson

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.recyclerview_guest, parent, false)
        view.setSize(parent.width/2-GRID_SPACING*2, parent.width/2-GRID_SPACING*2)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(mListPerson[position])
    }

    override fun getItemCount() = mListPerson.size

    fun refreshData(listPerson: ArrayList<Person>) {
        mListPerson = listPerson
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, val itemClick: (Person) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindForecast(person: Person) {
            with(person) {
                itemView.txtName.text = name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}