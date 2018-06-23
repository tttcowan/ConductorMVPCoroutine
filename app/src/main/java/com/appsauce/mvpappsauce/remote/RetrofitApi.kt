package com.appsauce.mvpappsauce.remote

import io.reactivex.Completable
import retrofit2.http.GET

interface RetrofitApi {

    @GET("posts")
    fun call(): Completable
}