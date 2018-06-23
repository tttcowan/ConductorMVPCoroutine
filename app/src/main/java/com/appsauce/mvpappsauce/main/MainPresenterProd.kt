package com.appsauce.mvpappsauce.main

import com.appsauce.mvpappsauce.navigation.NavigationService

class MainPresenterProd(private var view: MainView?,
                        private val navigationService: NavigationService) : MainPresenter {

    override fun viewReady() {
        navigationService.toHome()
    }

    override fun destroy() {
        view = null
        navigationService.destroy()
    }
}