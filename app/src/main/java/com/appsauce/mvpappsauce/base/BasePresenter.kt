package com.appsauce.mvpappsauce.base

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}