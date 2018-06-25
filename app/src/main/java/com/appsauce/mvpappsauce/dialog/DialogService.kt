package com.appsauce.mvpappsauce.dialog

interface DialogService {
    fun showTwoButtonDialog(primaryButton: String, secondaryButton: String, message: String, dialogId: DialogId)
    fun showSingleButtonDialog(primaryButton: String, message: String, dialogId: DialogId)
}