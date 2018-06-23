package com.appsauce.mvpappsauce.app

import android.content.Context
import android.support.multidex.MultiDexApplication

class App : MultiDexApplication() {

    companion object {
        @JvmStatic
        private lateinit var APP: App

        @JvmStatic
        fun context(): Context {
            return APP
        }
    }

    override fun onCreate() {
        super.onCreate()
        APP = this
    }

}