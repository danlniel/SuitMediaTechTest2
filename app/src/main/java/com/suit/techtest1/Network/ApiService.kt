package com.suit.techtest1.Network

import com.suit.techtest1.BuildConfig
import com.suit.techtest1.Model.Person
import io.reactivex.Observable
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 * Created by Daniel on 1/27/2018.
 */
interface ApiService {

    @GET("people")
    fun getGuest(): Observable<ArrayList<Person>>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build()

            return retrofit.create(ApiService::class.java);
        }
    }
}
//You can use dagger together with retrofit