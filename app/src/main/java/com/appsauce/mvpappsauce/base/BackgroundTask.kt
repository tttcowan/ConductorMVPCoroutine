package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundTask {

    private var clear: Boolean = false
    private val tasks: MutableList<CoroutineScope> = mutableListOf()

    fun <T> run(task: () -> T, complete: (value: T) -> Unit, error: (e: Exception) -> Unit) {
        clear = false
        GlobalScope.launch {
            tasks.add(this)
            try {
                if (!clear) {
                    val value = task()
                    tasks.remove(this)
                    withContext(Dispatchers.Main) { complete(value) }
                }
            } catch (e: Exception) {
                tasks.remove(this)
                "Call failed".logE(tag(), e)
                if (!clear) {
                    withContext(Dispatchers.Main) { error(e) }
                }
            }
        }
    }

    fun clear() {
        tasks.forEach {
            try {
                it.cancel()
            }
            catch (e : IllegalStateException) {
                //Task already cancelled.
            }
        }
        tasks.clear()
        clear = true
    }
}