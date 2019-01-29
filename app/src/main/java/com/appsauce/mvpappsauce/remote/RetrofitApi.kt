package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.remote.model.TestResponse
import io.reactivex.Completable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {

    @GET("get")
    fun postsRxJava(): Completable

    @GET("get")
    fun postsCoRoutine(): Call<TestResponse>
}