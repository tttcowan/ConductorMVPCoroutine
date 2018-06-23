package com.appsauce.mvpappsauce.remote

import io.reactivex.Completable

class RemoteServiceProd(private val service: ApiService) : RemoteService {
    override fun init(): Completable {
        return service.init()
    }
}