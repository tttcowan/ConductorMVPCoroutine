package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.app.App
import com.appsauce.mvpappsauce.dialog.DialogService
import com.appsauce.mvpappsauce.dialog.DialogServiceProd

object DialogModule {
    fun dialogService(): DialogService {
        return DialogServiceProd(App.getRouter())
    }
}