package com.suit.techtest1.Network

/**
 * Created by Daniel on 1/27/2018.
 */

object SearchApiDataProvider {
    fun provideSearchApiData(): SearchApiData {
        return SearchApiData(ApiService.Factory.create())
    }
}