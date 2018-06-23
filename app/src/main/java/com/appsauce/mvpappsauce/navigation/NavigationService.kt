package com.appsauce.mvpappsauce.navigation

import com.bluelinelabs.conductor.Router

interface NavigationService {
    fun handleBack(): Boolean
    fun toHome()
    fun destroy()
}