package com.appsauce.mvpappsauce.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsauce.mvpappsauce.R
import com.appsauce.mvpappsauce.base.BaseController
import com.appsauce.mvpappsauce.extension.toast
import com.appsauce.mvpappsauce.module.PresenterModule

class HomeController : BaseController<HomeView, HomePresenter>(), HomeView {

    override lateinit var presenter: HomePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        presenter = PresenterModule.home()
        return inflater.inflate(R.layout.controller_home, container, false)
    }

    override fun callComplete() {
        presenter.callReturn()
    }

    override fun dialogReturn() {
        "Dialog callback".toast()
    }

}