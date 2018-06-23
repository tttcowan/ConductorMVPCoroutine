package com.appsauce.mvpappsauce.home

import com.appsauce.mvpappsauce.base.BasePresenter

interface HomePresenter : BasePresenter<HomeView> {
    fun callReturn()
}