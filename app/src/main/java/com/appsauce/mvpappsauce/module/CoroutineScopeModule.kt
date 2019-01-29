package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.coroutine.CoroutineScopes
import com.appsauce.mvpappsauce.coroutine.CoroutineScopesProd

object CoroutineScopeModule {

    fun scopes(): CoroutineScopes {
        return CoroutineScopesProd()
    }
}