package com.appsauce.mvpappsauce.navigation

import com.appsauce.mvpappsauce.base.BaseController
import com.appsauce.mvpappsauce.base.BasePresenter
import com.appsauce.mvpappsauce.base.BaseView
import com.appsauce.mvpappsauce.home.HomeController
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler

class NavigationServiceProd(private var router: Router?) : NavigationService {

    override fun toHome() {
        replaceRoot(HomeController())
    }

    override fun handleBack(): Boolean {
        return router?.handleBack() ?: false
    }

    override fun destroy() {
        router = null
    }

    private fun <V : BaseView, P : BasePresenter<V>> navigate(controller: BaseController<V, P>, fade: Boolean = true, isModal: Boolean = false) {
        //Attempt pop to TAG
        val popped = router?.popToTag(controller.tag()) ?: false
        if (!popped) {
            //Tag not found so push controller to top of stack
            var transaction = RouterTransaction.with(controller).tag(controller.tag())
            if (fade) {
                transaction = transaction.popChangeHandler(FadeChangeHandler()).pushChangeHandler(FadeChangeHandler(!isModal))
            }
            router?.pushController(transaction)
        }
    }

    private fun <V : BaseView, P : BasePresenter<V>> replaceRoot(controller: BaseController<V, P>, fade: Boolean = true) {
        var transaction = RouterTransaction.with(controller).tag(controller.tag())
        if (fade) {
            transaction = transaction.popChangeHandler(FadeChangeHandler()).pushChangeHandler(FadeChangeHandler())
        }
        router?.setRoot(transaction)
    }

    private fun <V : BaseView, P : BasePresenter<V>> replaceTop(controller: BaseController<V, P>, fade: Boolean = true) {
        var transaction = RouterTransaction.with(controller).tag(controller.tag())
        if (fade) {
            transaction = transaction.popChangeHandler(FadeChangeHandler()).pushChangeHandler(FadeChangeHandler())
        }
        router?.replaceTopController(transaction)
    }


}