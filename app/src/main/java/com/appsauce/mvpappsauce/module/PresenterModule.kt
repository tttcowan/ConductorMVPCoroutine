package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.dialog.singlebutton.SingleButtonDialogPresenter
import com.appsauce.mvpappsauce.dialog.singlebutton.SingleButtonDialogPresenterProd
import com.appsauce.mvpappsauce.dialog.twobutton.TwoButtonDialogPresenter
import com.appsauce.mvpappsauce.dialog.twobutton.TwoButtonDialogPresenterProd
import com.appsauce.mvpappsauce.home.HomePresenter
import com.appsauce.mvpappsauce.home.HomePresenterProd
import com.appsauce.mvpappsauce.main.MainPresenter
import com.appsauce.mvpappsauce.main.MainPresenterProd
import com.appsauce.mvpappsauce.main.MainView

object PresenterModule {

    //Dialog
    fun twoButtonDialog(): TwoButtonDialogPresenter {
        return TwoButtonDialogPresenterProd()
    }

    fun singleButtonDialog(): SingleButtonDialogPresenter {
        return SingleButtonDialogPresenterProd()
    }

    //Screens
    fun main(view: MainView): MainPresenter {
        return MainPresenterProd(view, NavigationModule.navigationService())
    }

    fun home(): HomePresenter {
        return HomePresenterProd(RemoteModule.remoteService(),
                NavigationModule.navigationService(),
                DialogModule.dialogService())
    }
}