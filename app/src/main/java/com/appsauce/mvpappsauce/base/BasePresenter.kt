package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.dialog.DialogId

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)
    fun detachView()
    fun dialogDismiss(dialogId: DialogId)
    fun dialogPrimary(dialogId: DialogId)
    fun dialogSecondary(dialogId: DialogId)
}