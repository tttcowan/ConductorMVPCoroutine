package com.appsauce.mvpappsauce.remote

import io.reactivex.Completable

interface ApiService {
    fun init(): Completable
}