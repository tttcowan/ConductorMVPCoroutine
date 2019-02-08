package com.appsauce.mvpappsauce.coroutine

import kotlin.coroutines.CoroutineContext

interface CoroutineContexts {
    fun subscribe(): CoroutineContext
    fun observe(): CoroutineContext
}