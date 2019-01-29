package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundTask {

    private var clear: Boolean = false

    fun <T> run(task: () -> T, complete: (value: T) -> Unit, error: (e: Exception) -> Unit) {
        clear = false
        GlobalScope.launch {
            try {
                if (!clear) {
                    val value = task()
                    withContext(Dispatchers.Main) { complete(value) }
                }
            } catch (e: Exception) {
                "Call failed".logE(tag(), e)
                if (!clear) {
                    withContext(Dispatchers.Main) { error(e) }
                }
            }
        }
    }

    fun clear() {
        clear = true
    }
}