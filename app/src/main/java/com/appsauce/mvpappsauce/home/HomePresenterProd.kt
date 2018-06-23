package com.appsauce.mvpappsauce.home

import com.appsauce.mvpappsauce.base.BasePresenterProd
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.appsauce.mvpappsauce.remote.RemoteService
import io.reactivex.rxkotlin.subscribeBy

class HomePresenterProd(private val remote: RemoteService,
                        private val navigation: NavigationService) : BasePresenterProd<HomeView>(), HomePresenter<HomeView> {

    override fun attachView(view: HomeView) {
        super.attachView(view)
        disposable.add(remote.init().subscribeBy {
            view.callComplete()
        })
    }
}