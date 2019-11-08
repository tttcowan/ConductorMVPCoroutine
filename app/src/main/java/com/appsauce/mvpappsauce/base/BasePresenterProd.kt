package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.coroutine.BackgroundTask
import com.appsauce.mvpappsauce.dialog.DialogId
import com.appsauce.mvpappsauce.extension.tag
import com.appsauce.mvpappsauce.module.CoroutineSchedulerModule

abstract class BasePresenterProd<V : BaseView> : BasePresenter<V> {

    protected val backgroundTask = BackgroundTask(CoroutineSchedulerModule.scopes())

    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
        backgroundTask.clear(tag())
    }

    override fun dialogDismiss(dialogId: DialogId) {
    }

    override fun dialogPrimary(dialogId: DialogId) {
    }

    override fun dialogSecondary(dialogId: DialogId) {
    }
}