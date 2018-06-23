package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.app.App
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.appsauce.mvpappsauce.navigation.NavigationServiceProd

object NavigationModule {
    fun navigationService(): NavigationService {
        return NavigationServiceProd(App.getRouter())
    }
}