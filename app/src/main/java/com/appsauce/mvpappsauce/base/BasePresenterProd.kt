package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.coroutine.BackgroundTask
import com.appsauce.mvpappsauce.dialog.DialogId
import com.appsauce.mvpappsauce.module.CoroutineScopeModule
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterProd<V : BaseView> : BasePresenter<V> {

    protected val disposable = CompositeDisposable()
    //Inject scopes, for testing the module would need updating in it's current form. There could be a better way.
    protected val backgroundTask = BackgroundTask(CoroutineScopeModule.scopes())

    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
        disposable.clear()
        backgroundTask.clear()
    }

    override fun dialogDismiss(dialogId: DialogId) {
    }

    override fun dialogPrimary(dialogId: DialogId) {
    }

    override fun dialogSecondary(dialogId: DialogId) {
    }
}