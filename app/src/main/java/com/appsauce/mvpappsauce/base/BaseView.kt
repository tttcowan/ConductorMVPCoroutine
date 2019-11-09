package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.dialog.DialogId

interface BaseView {
    fun toast(toast: String)
    fun dialogDismiss(dialogId: DialogId)
    fun dialogPrimary(dialogId: DialogId)
    fun dialogSecondary(dialogId: DialogId)
}