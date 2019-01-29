package com.appsauce.mvpappsauce.extension

import android.util.Log
import com.appsauce.mvpappsauce.util.DebugUtil

fun String.logD(tag: String) {
    if (DebugUtil.isDebug()) {
        Log.d(tag, this)
    }
}

fun String.logI(tag: String) {
    Log.i(tag, this)
}

fun String.logE(tag: String, logNonFatal: Boolean = true) {
    if (DebugUtil.isDebug()) {
        Log.e(tag, this)
    }
    if (DebugUtil.isErrorReporting() && logNonFatal) {
//        val exception = Exception(this)
//        Crashlytics.getInstance().core.log(Log.ERROR, tag, this)
//        Crashlytics.logException(exception)
    }
}

fun String.logE(tag: String, exception: Throwable, logNonFatal: Boolean = true) {
    if (DebugUtil.isDebug()) {
        Log.e(tag, this, exception)
    }
    if (DebugUtil.isErrorReporting() && logNonFatal) {
//        Crashlytics.getInstance().core.log(Log.ERROR, tag, this)
//        Crashlytics.logException(exception)
    }
}