package com.appsauce.mvpappsauce.dialog.twobutton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appsauce.mvpappsauce.R
import com.appsauce.mvpappsauce.base.BaseController
import com.appsauce.mvpappsauce.base.BaseView
import com.appsauce.mvpappsauce.dialog.DialogId
import com.appsauce.mvpappsauce.module.PresenterModule
import kotlinx.android.synthetic.main.controller_two_button_dialog.view.messageText
import kotlinx.android.synthetic.main.controller_two_button_dialog.view.primaryButton
import kotlinx.android.synthetic.main.controller_two_button_dialog.view.secondaryBalance

class TwoButtonDialogController(bundle: Bundle) : BaseController<TwoButtonDialogView, TwoButtonDialogPresenter>(bundle),
    TwoButtonDialogView {

    override lateinit var presenter: TwoButtonDialogPresenter

    private val dialogText = bundle.getString(KEY_DIALOG_TEXT)
    private val primaryButtonText = bundle.getString(KEY_PRIMARY_BUTTON_TEXT)
    private val secondaryButtonText = bundle.getString(KEY_SECONDARY_BUTTON_TEXT)
    private val dialogId: DialogId =
        bundle.getParcelable(KEY_DIALOG_ID) ?: throw RuntimeException("Dialog id not found")

    companion object {

        private const val KEY_DIALOG_ID = "KEY_DIALOG_ID"
        private const val KEY_DIALOG_TEXT = "KEY_DIALOG_TEXT"
        private const val KEY_PRIMARY_BUTTON_TEXT = "KEY_PRIMARY_BUTTON_TEXT"
        private const val KEY_SECONDARY_BUTTON_TEXT = "KEY_SECONDARY_BUTTON_TEXT"

        internal fun newInstance(
            primaryButtonText: String,
            secondaryButtonText: String,
            dialogText: String,
            dialogId: DialogId
        ): TwoButtonDialogController {
            val bundle = Bundle()
            bundle.putString(KEY_DIALOG_TEXT, dialogText)
            bundle.putString(KEY_PRIMARY_BUTTON_TEXT, primaryButtonText)
            bundle.putString(KEY_SECONDARY_BUTTON_TEXT, secondaryButtonText)
            bundle.putParcelable(KEY_DIALOG_ID, dialogId)
            return TwoButtonDialogController(bundle)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_two_button_dialog, container, false)
        presenter = PresenterModule.twoButtonDialog()
        view.primaryButton.text = primaryButtonText
        view.secondaryBalance.text = secondaryButtonText
        view.messageText.text = dialogText
        setOnClickListeners(view)
        return view
    }

    private fun setOnClickListeners(view: View) {
        view.primaryButton.setOnClickListener { primary() }
        view.secondaryBalance.setOnClickListener { secondary() }
        view.setOnClickListener { dismiss() }
    }

    override fun handleBack(): Boolean {
        return true
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

    private fun secondary() {
        val controller = targetController
            ?: throw RuntimeException("Failed to find target controller")
        if (controller is BaseView) {
            controller.dialogSecondary(dialogId)
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