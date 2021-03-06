package com.appsauce.mvpappsauce.home

import com.appsauce.mvpappsauce.base.BasePresenterProd
import com.appsauce.mvpappsauce.dialog.DialogId
import com.appsauce.mvpappsauce.dialog.DialogService
import com.appsauce.mvpappsauce.extension.logE
import com.appsauce.mvpappsauce.extension.tag
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.appsauce.mvpappsauce.remote.RemoteService

class HomePresenterProd(
    private val remote: RemoteService,
    private val navigation: NavigationService,
    private val dialogServiceProd: DialogService
) : BasePresenterProd<HomeView>(), HomePresenter {

    override fun attachView(view: HomeView) {
        super.attachView(view)
        // Coroutine call example
        backgroundTask.run(
            task = {
                remote.initCoroutine()
            },
            complete = {
                view.callComplete()
            },
            error = {
                view.callError()
                "Call failed".logE(tag(), it)
            })
    }

    override fun callReturn() {
        dialogServiceProd.showTwoButtonDialog("Ok", "Cancel", "Dialog Test", DialogId.DEFAULT)
    }

    override fun dialogDismiss(dialogId: DialogId) {
        view?.dialogReturn()
    }

    override fun dialogPrimary(dialogId: DialogId) {
        view?.dialogReturn()
    }

    override fun dialogSecondary(dialogId: DialogId) {
        view?.dialogReturn()
    }
}