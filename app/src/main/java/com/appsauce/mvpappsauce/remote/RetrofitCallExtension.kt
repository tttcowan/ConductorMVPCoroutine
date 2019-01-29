package com.appsauce.mvpappsauce.remote

import retrofit2.Call

fun <T> Call<T>.makeCall(): T {
    val response = execute()
    if (response.isSuccessful) {
        return response.body() ?: throw RuntimeException("Response cannot be null")
    } else {
        throw Exception(response.errorBody()!!.string())
    }
}