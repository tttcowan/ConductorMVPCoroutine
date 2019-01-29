package com.appsauce.mvpappsauce.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface CoroutineScopes {
    fun subscribe(): CoroutineScope
    fun observe(): CoroutineDispatcher
}