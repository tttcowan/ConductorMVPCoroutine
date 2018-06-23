package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.main.MainActivity
import com.appsauce.mvpappsauce.navigation.NavigationService

object NavigationModule {
    fun navigationService(): NavigationService {
        return MainActivity.navigationService
    }
}