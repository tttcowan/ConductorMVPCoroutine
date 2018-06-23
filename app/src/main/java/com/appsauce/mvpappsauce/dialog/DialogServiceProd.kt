package com.appsauce.mvpappsauce.dialog

import com.appsauce.mvpappsauce.dialog.twobutton.TwoButtonDialogController
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler

class DialogServiceProd(private val router: Router?) : DialogService {

    override fun showTwoButtonDialog(primaryButton: String, secondaryButton: String, message: String) {
        navigate(TwoButtonDialogController.newInstance(primaryButton, secondaryButton, message))
    }

    private fun navigate(controller: Controller) {
        router?.let {
            val parent = router.backstack[router.backstackSize - 1].controller()
            controller.targetController = parent
            router.pushController(RouterTransaction.with(controller)
                    .pushChangeHandler(FadeChangeHandler(false))
                    .popChangeHandler(FadeChangeHandler())
            )
        }
    }

}