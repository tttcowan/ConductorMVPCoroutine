package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.coroutine.CoroutineContexts
import com.appsauce.mvpappsauce.coroutine.CoroutineContextsProd
import com.appsauce.mvpappsauce.coroutine.CoroutineContextsTest

object CoroutineScopeModule {

    private var testing: Boolean = false

    fun scopes(): CoroutineContexts {
        return if (!testing) {
            CoroutineContextsProd()
        } else {
            CoroutineContextsTest()
        }
    }

    fun testing() {
        testing = true
    }
}