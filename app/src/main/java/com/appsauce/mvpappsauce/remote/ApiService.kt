package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.remote.model.TestResponse
import io.reactivex.Completable

interface ApiService {
    fun initRxJava(): Completable
    fun initCoroutine(): TestResponse
}