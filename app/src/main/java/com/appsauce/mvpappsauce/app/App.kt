package com.appsauce.mvpappsauce.app

import android.content.Context
import android.support.multidex.MultiDexApplication
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

    }

    private var router: Router? = null

    override fun onCreate() {
        super.onCreate()
        APP = this
    }

}