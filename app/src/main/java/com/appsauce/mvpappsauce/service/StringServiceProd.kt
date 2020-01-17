package com.appsauce.mvpappsauce.service

import androidx.annotation.StringRes
import com.appsauce.mvpappsauce.app.App

class StringServiceProd : StringService {

    override fun getString(@StringRes stringResourceId: Int): String {
        return App.resources().getString(stringResourceId)
    }
}