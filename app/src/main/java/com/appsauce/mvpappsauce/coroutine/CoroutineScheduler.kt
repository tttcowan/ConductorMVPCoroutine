package com.appsauce.mvpappsauce.coroutine

import kotlin.coroutines.CoroutineContext

interface CoroutineScheduler {
    fun subscribe(): CoroutineContext
    fun observe(): CoroutineContext
}