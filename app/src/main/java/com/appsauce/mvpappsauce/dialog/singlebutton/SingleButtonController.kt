package com.appsauce.mvpappsauce.dialog.singlebutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsauce.mvpappsauce.R
import com.appsauce.mvpappsauce.base.BaseController
import com.appsauce.mvpappsauce.base.BaseView
import com.appsauce.mvpappsauce.dialog.DialogId
import com.appsauce.mvpappsauce.module.PresenterModule
import kotlinx.android.synthetic.main.controller_single_button_dialog.view.*

class SingleButtonController(bundle: Bundle) : BaseController<SingleButtonDialogView, SingleButtonDialogPresenter>(bundle), SingleButtonDialogView {

    override lateinit var presenter: SingleButtonDialogPresenter

    private val dialogText = bundle.getString(KEY_DIALOG_TEXT)
    private val primaryButtonText = bundle.getString(KEY_PRIMARY_BUTTON_TEXT)
    private val dialogId: DialogId = bundle.getParcelable(KEY_DIALOG_ID)

    companion object {

        private const val KEY_DIALOG_ID = "KEY_DIALOG_TEXT"
        private const val KEY_DIALOG_TEXT = "KEY_DIALOG_TEXT"
        private const val KEY_PRIMARY_BUTTON_TEXT = "KEY_PRIMARY_BUTTON_TEXT"

        internal fun newInstance(primaryButtonText: String, dialogText: String, dialogId: DialogId): SingleButtonController {
            val bundle = Bundle()
            bundle.putString(KEY_DIALOG_TEXT, dialogText)
            bundle.putString(KEY_PRIMARY_BUTTON_TEXT, primaryButtonText)
            bundle.putParcelable(KEY_DIALOG_ID, dialogId)
            return SingleButtonController(bundle)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_single_button_dialog, container, false)
        presenter = PresenterModule.singleButtonDialog()
        view.primaryButton.text = primaryButtonText
        view.messageText.text = dialogText
        setOnClickListeners(view)
        return view
    }


    private fun setOnClickListeners(view: View) {
        view.primaryButton.setOnClickListener { primary() }
        view.setOnClickListener { dismiss() }
    }

    private fun primary() {
        val controller = targetController
                ?: throw RuntimeException("Failed to find target controller")
        if (controller is BaseView) {
            controller.dialogPrimary(dialogId)
        } else {
            throw RuntimeException("Controller is not BaseView")
        }
        router.popController(this)
    }

    private fun dismiss() {
        val controller = targetController
                ?: throw RuntimeException("Failed to find target controller")
        if (controller is BaseView) {
            controller.dialogDismiss(dialogId)
        } else {
            throw RuntimeException("Controller is not BaseView")
        }
        router.popController(this)
    }

}