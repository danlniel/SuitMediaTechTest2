package com.suit.techtest1.Network

import com.suit.techtest1.Model.Person

/**
 * Created by Daniel on 1/27/2018.
 */

class SearchApiData(val apiService: ApiService) {
    fun getGuest(): io.reactivex.Observable<ArrayList<Person>> {
        return apiService.getGuest()
    }
}