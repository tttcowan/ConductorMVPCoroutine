package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.remote.ApiServiceProd
import com.appsauce.mvpappsauce.remote.RemoteService
import com.appsauce.mvpappsauce.remote.RemoteServiceProd


object RemoteModule {

    private val remoteService: RemoteService = RemoteServiceProd(ApiServiceProd())

    fun remoteService(): RemoteService {
        return remoteService
    }

}