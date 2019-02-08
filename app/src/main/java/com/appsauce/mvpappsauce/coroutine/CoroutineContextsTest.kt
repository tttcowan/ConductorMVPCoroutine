package com.appsauce.mvpappsauce.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlin.coroutines.CoroutineContext

class CoroutineContextsTest : CoroutineContexts {

    @UseExperimental(ExperimentalCoroutinesApi::class)
    override fun subscribe(): CoroutineContext {
        return GlobalScope.coroutineContext + Dispatchers.Unconfined
    }

    @UseExperimental(ExperimentalCoroutinesApi::class)
    override fun observe(): CoroutineContext {
        return GlobalScope.coroutineContext + Dispatchers.Unconfined
    }
}