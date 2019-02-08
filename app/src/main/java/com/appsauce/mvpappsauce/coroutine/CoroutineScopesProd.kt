package com.appsauce.mvpappsauce.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class CoroutineScopesProd : CoroutineScopes {
    override fun subscribe(): CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }

    override fun observe(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}