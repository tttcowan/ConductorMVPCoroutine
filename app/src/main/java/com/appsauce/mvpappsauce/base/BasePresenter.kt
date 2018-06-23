package com.appsauce.mvpappsauce.base

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)
    fun detachView()
    fun dialogDismiss()
    fun dialogPrimary()
    fun dialogSecondary()
}