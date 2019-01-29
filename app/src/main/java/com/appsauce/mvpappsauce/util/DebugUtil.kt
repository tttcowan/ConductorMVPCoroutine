package com.appsauce.mvpappsauce.util

import com.appsauce.mvpappsauce.BuildConfig

object DebugUtil {

    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    fun isErrorReporting(): Boolean {
        //Allows switching of crashlytics etc. on/off.
        return true
    }
}