package com.appsauce.mvpappsauce.coroutine

import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BackgroundTask(private val coroutineScheduler: CoroutineScheduler) {

    private val jobs: MutableList<Job> = mutableListOf()

    fun <T> run(
        // Task to run
        task: suspend () -> T,
        complete: (value: T) -> Unit = {},
        error: (e: Exception) -> Unit = {}
    ) { val job = Job()
        GlobalScope.launch(coroutineScheduler.subscribe() + job) {
            try {
                val value = task()
                withContext(coroutineScheduler.observe() + job) { complete(value) }
            } catch (e: Exception) {
                "Call failed".logE(tag(), e)
                withContext(coroutineScheduler.observe() + job) { error(e) }
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

    fun <T> observe(
        task: suspend () -> T,
        observe: (state: TaskState<T>) -> Unit
    ) {
        observe(TaskState.Loading())
        run(task, {
            observe(TaskState.Success(it))
        }, {
            observe(TaskState.Error(it))
        })
    }

    sealed class TaskState<T> {
        class Success<T>(val response: T) : TaskState<T>()
        class Error<T>(val error: Exception) : TaskState<T>()
        class Loading<T> : TaskState<T>()
    }
}