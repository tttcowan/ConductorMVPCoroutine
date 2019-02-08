package com.appsauce.mvpappsauce.coroutine

import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundTask(private val coroutineContexts: CoroutineContexts) {

    private var clear: Boolean = false
    private val tasks: MutableList<CoroutineScope> = mutableListOf()

    fun <T> run(
        // Task to run
        task: suspend () -> T,
        complete: (value: T) -> Unit = {},
        error: (e: Exception) -> Unit = {}
    ) {
        clear = false

        GlobalScope.launch(coroutineContexts.subscribe()) {
            // Create new coroutine scope for cancelling.
            coroutineScope {
                tasks.add(this)
                try {
                    if (!clear) {
                        val value = task()
                        tasks.remove(this)
                        withContext(coroutineContexts.observe()) { complete(value) }
                    }
                } catch (e: Exception) {
                    tasks.remove(this)
                    "Call failed".logE(tag(), e)
                    if (!clear) {
                        withContext(coroutineContexts.observe()) { error(e) }
                    }
                }
            }
        }
    }

    @UseExperimental(ExperimentalCoroutinesApi::class)
    fun clear() {
        tasks.forEach {
            try {
                it.cancel()
            } catch (e: IllegalStateException) {
                // Task already cancelled.
            }
        }
        tasks.clear()
        clear = true
    }
}