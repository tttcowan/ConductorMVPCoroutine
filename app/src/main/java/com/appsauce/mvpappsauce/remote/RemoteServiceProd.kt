package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.remote.model.TestResponse
import io.reactivex.Completable

class RemoteServiceProd(private val service: ApiService) : RemoteService {

    override fun initCoroutine(): () -> TestResponse {
        return { service.initCoroutine() }
    }
}