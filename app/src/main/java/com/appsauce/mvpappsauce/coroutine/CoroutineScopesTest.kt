package com.appsauce.mvpappsauce.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class CoroutineScopesTest : CoroutineScopes {

    override fun subscribe(): CoroutineScope {
        return CoroutineScope(Dispatchers.Unconfined)
    }

    override fun observe(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }
}