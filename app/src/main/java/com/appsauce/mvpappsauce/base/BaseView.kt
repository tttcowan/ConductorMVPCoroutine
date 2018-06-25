package com.appsauce.mvpappsauce.base

import com.appsauce.mvpappsauce.dialog.DialogId

interface BaseView {
    fun dialogDismiss(dialogId: DialogId)
    fun dialogPrimary(dialogId: DialogId)
    fun dialogSecondary(dialogId: DialogId)
}