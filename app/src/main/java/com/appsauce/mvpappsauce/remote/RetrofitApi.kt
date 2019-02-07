package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.remote.model.TestResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RetrofitApi {

    @GET("get")
    fun postsCoroutineAsync(): Deferred<TestResponse>
}