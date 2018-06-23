package com.appsauce.mvpappsauce.util

import com.appsauce.mvpappsauce.BuildConfig


object DebugUtil {

    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

}