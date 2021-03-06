package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.app.Constants
import com.appsauce.mvpappsauce.remote.model.TestResponse
import com.appsauce.mvpappsauce.util.DebugUtil
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceProd : ApiService {

    private val gson: Gson = GsonBuilder().create()

    private fun okHttpClient(): OkHttpClient {
        var builder = OkHttpClient.Builder()
        if (DebugUtil.isDebug()) {
            builder = builder.addNetworkInterceptor(StethoInterceptor())
        }
        return builder.build()
    }

    private val service: RetrofitApi =
        Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient())
            .baseUrl(Constants.ENDPOINT)
            .build()
            .create(RetrofitApi::class.java)

    override suspend fun initCoroutine(): TestResponse {
        return service.postsCoroutineAsync().await()
    }
}