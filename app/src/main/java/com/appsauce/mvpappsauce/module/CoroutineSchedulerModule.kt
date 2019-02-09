package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.coroutine.CoroutineScheduler
import com.appsauce.mvpappsauce.coroutine.CoroutineSchedulerProd
import com.appsauce.mvpappsauce.coroutine.CoroutineSchedulerTest

object CoroutineSchedulerModule {

    private var testing: Boolean = false

    fun scopes(): CoroutineScheduler {
        return if (!testing) {
            CoroutineSchedulerProd()
        } else {
            CoroutineSchedulerTest()
        }
    }

    fun testing() {
        testing = true
    }
}