package com.appsauce.mvpappsauce.coroutine

import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundTask(private val scopes: CoroutineScopes) {

    private var clear: Boolean = false
    private val tasks: MutableList<CoroutineScope> = mutableListOf()

    fun <T> run(
        task: () -> T,
        complete: (value: T) -> Unit,
        error: (e: Exception) -> Unit
    ) {
        clear = false
        scopes.subscribe().launch {
            tasks.add(this)
            try {
                if (!clear) {
                    val value = task()
                    tasks.remove(this)
                    withContext(scopes.observe()) { complete(value) }
                }
            } catch (e: Exception) {
                tasks.remove(this)
                "Call failed".logE(tag(), e)
                if (!clear) {
                    withContext(scopes.observe()) { error(e) }
                }
            }
        }
    }

    fun clear() {
        tasks.forEach {
            try {
                it.cancel()
            } catch (e: IllegalStateException) {
                //Task already cancelled.
            }
        }
        tasks.clear()
        clear = true
    }
}