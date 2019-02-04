package com.appsauce.mvpappsauce.extension

import android.content.Context
import android.net.ConnectivityManager

fun Context.isNetworkAvailable(): Boolean {
    return try {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        activeNetwork != null
    } catch (e: Exception) {
        "Failed to detect network conditions".logE("Context.isNetworkAvailable", e, true)
        false
    }
}
