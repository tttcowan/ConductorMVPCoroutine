package com.appsauce.mvpappsauce.home

import com.appsauce.mvpappsauce.base.BasePresenterProd
import com.appsauce.mvpappsauce.dialog.DialogService
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.appsauce.mvpappsauce.remote.RemoteService
import io.reactivex.rxkotlin.subscribeBy

class HomePresenterProd(private val remote: RemoteService,
                        private val navigation: NavigationService,
                        private val dialogServiceProd: DialogService) : BasePresenterProd<HomeView>(), HomePresenter {

    override fun callReturn() {
        dialogServiceProd.showTwoButtonDialog("Ok", "Cancel", "Dialog Test")
    }

    override fun attachView(view: HomeView) {
        super.attachView(view)
        disposable.add(remote.init().subscribeBy {
            view.callComplete()
        })
    }

    override fun dialogDismiss() {
        view?.dialogReturn()
    }

    override fun dialogPrimary() {
        view?.dialogReturn()
    }

    override fun dialogSecondary() {
        view?.dialogReturn()
    }
}