package com.appsauce.mvpappsauce.remote

import io.reactivex.Completable


interface RemoteService {
    fun init(): Completable
}