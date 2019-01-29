package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.remote.model.TestResponse
import io.reactivex.Completable
import retrofit2.Call

class RemoteServiceProd(private val service: ApiService) : RemoteService {
    override fun initRxJava(): Completable {
        return service.initRxJava()
    }

    override fun initCoRoutine() : TestResponse {
        return service.initCoRoutine()
    }

}