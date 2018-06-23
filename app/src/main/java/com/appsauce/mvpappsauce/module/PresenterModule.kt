package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.home.HomePresenter
import com.appsauce.mvpappsauce.home.HomePresenterProd
import com.appsauce.mvpappsauce.home.HomeView

object PresenterModule {

    fun home(): HomePresenter<HomeView> {
        return HomePresenterProd(RemoteModule.remoteService(), NavigationModule.navigationService())
    }
}