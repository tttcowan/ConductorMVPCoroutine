package com.appsauce.mvpappsauce.base

import android.os.Bundle
import android.view.View
import com.bluelinelabs.conductor.Controller

abstract class BaseController<in V : BaseView, P : BasePresenter<V>> : Controller, BaseView {

    fun tag(): String {
        return this::class.java.simpleName
    }

    constructor() : super()
    constructor(bundle: Bundle) : super(bundle)

    abstract var presenter: P

    override fun onAttach(view: View) {
        super.onAttach(view)
        @Suppress("UNCHECKED_CAST")
        presenter.attachView(this as V)
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        presenter.detachView()
    }

}