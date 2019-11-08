package com.appsauce.mvpappsauce.coroutine

import com.appsauce.mvpappsauce.extension.logD
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
    ) {
        val job = GlobalScope.launch(coroutineScheduler.subscribe()) {
            try {
                val value = task()
                withContext(coroutineScheduler.observe()) { complete(value) }
            } catch (e: Exception) {
                "Call failed".logE(tag(), e)
                withContext(coroutineScheduler.observe()) { error(e) }
            }
        }
        jobs.add(job)
        job.invokeOnCompletion {
            "Job removed".logD(tag())
            jobs.remove(job)
        }
    }

    fun clear(sourceTag: String) {
        "Clear called from : $sourceTag".logD(tag())
        try {
            jobs.forEach {
                try {
                    it.cancel()
                    "$sourceTag : Job cancelled : $it".logD(tag())
                } catch (e: Exception) {
                    // Task already cancelled.
                }
            }
        } catch (e: Exception) {
            "Jobs for each exception".logE(tag(), e)
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