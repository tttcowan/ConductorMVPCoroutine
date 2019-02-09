package com.appsauce.mvpappsauce.coroutine

import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundTask(private val coroutineContexts: CoroutineContexts) {

    private val jobs: MutableList<Job> = mutableListOf()

    fun <T> run(
        // Task to run
        task: suspend () -> T,
        complete: (value: T) -> Unit = {},
        error: (e: Exception) -> Unit = {}
    ) {
        val job: Job = GlobalScope.launch(coroutineContexts.subscribe()) {
            try {
                val value = task()
                withContext(coroutineContexts.observe()) { complete(value) }
            } catch (e: Exception) {
                "Call failed".logE(tag(), e)
                withContext(coroutineContexts.observe()) { error(e) }
            }
        }
        jobs.add(job)
        job.invokeOnCompletion { jobs.remove(job) }
    }

    fun clear() {
        jobs.forEach {
            try {
                it.cancel()
            } catch (e: IllegalStateException) {
                // Task already cancelled.
            }
        }
        jobs.clear()
    }
}