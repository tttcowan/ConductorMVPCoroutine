package com.appsauce.mvpappsauce.remote

import com.appsauce.mvpappsauce.remote.model.TestResponse

interface RemoteService {
    fun initCoroutine(): () -> TestResponse
}