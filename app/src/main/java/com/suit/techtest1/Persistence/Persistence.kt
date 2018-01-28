package com.suit.techtest1.Persistence

import com.suit.techtest1.Model.Event
import com.suit.techtest1.Utils.Utils

/**
 * Created by Daniel on 1/27/2018.
 */

public class Persistence() {
    companion object {
        val shared = Persistence()
    }

    val listEvent: ArrayList<Event> =
            arrayListOf(Event( "Abi", Utils.createDate("12", "2", "2000"), "https://webkit.org/demos/srcset/image-src.png"),
            Event("Dandy", Utils.createDate("13", "2", "2000"), "https://webkit.org/demos/srcset/image-src.png"),
            Event("Heli", Utils.createDate("14", "2", "2000"), "https://webkit.org/demos/srcset/image-src.png"),
            Event("Sandy", Utils.createDate("15", "2", "2000"), "https://webkit.org/demos/srcset/image-src.png"),
            Event("Popo", Utils.createDate("17", "7", "2000"), "https://webkit.org/demos/srcset/image-src.png"))
}