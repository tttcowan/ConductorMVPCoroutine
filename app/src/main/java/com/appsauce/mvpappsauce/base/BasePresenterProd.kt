package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.dialog.DialogId
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterProd<V : BaseView> : BasePresenter<V> {

    protected val disposable = CompositeDisposable()

    protected var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
        disposable.clear()
    }

    override fun dialogDismiss(dialogId: DialogId) {
    }

    override fun dialogPrimary(dialogId: DialogId) {

    }

    override fun dialogSecondary(dialogId: DialogId) {

    }

}