package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.coroutine.CoroutineScopes
import com.appsauce.mvpappsauce.coroutine.CoroutineScopesProd
import com.appsauce.mvpappsauce.coroutine.CoroutineScopesTest

object CoroutineScopeModule {

    private var testing: Boolean = false

    fun scopes(): CoroutineScopes {
        return if (!testing) {
            CoroutineScopesProd()
        } else {
            CoroutineScopesTest()
        }
    }

    fun testing() {
        testing = true
    }
}