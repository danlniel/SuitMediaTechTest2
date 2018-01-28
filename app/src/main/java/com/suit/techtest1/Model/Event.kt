package com.suit.techtest1.Model

import android.os.Parcel
import android.os.Parcelable
import com.suit.techtest1.Helper.Constant
import java.util.*

/**
 * Created by Daniel on 1/27/2018.
 */
data class Event(val id: String,
                 override val name: String,
                 var imageUrl: String,
                 val date: Date) : GlobalName {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            Date()) {
    }

    constructor(name: String, date: Date, imageUrl: String) : this(Constant.getPk().toString(), name, imageUrl, date)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(parcel)
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }
    }

}