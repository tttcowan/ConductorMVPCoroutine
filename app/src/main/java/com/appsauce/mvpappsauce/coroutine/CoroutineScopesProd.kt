package com.appsauce.mvpappsauce.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

class CoroutineScopesProd : CoroutineScopes {
    override fun subscribe(): CoroutineScope {
        return GlobalScope
    }

    override fun observe(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}