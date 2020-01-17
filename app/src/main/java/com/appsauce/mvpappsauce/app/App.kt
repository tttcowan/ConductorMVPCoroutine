package com.appsauce.mvpappsauce.app

import android.content.Context
import android.content.res.Resources
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.bluelinelabs.conductor.Router

class App : MultiDexApplication() {

    companion object {
        @JvmStatic
        private lateinit var APP: App

        @JvmStatic
        fun context(): Context {
            return APP
        }

        @JvmStatic
        fun setRouter(router: Router?) {
            APP.router = router
        }

        @JvmStatic
        fun getRouter(): Router? {
            return APP.router
        }

        @JvmStatic
        fun resources(): Resources {
            return APP.resources
        }
    }

    private var router: Router? = null

    override fun onCreate() {
        super.onCreate()
        APP = this
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}