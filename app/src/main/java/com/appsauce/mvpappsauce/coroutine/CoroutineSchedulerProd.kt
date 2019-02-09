package com.appsauce.mvpappsauce.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlin.coroutines.CoroutineContext

class CoroutineSchedulerProd : CoroutineScheduler {
    override fun subscribe(): CoroutineContext {
        return GlobalScope.coroutineContext + Dispatchers.Default
    }

    override fun observe(): CoroutineContext {
        return GlobalScope.coroutineContext + Dispatchers.Main
    }
}