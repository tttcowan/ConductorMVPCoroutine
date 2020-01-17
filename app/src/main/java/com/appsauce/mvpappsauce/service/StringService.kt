package com.appsauce.mvpappsauce.service

import androidx.annotation.StringRes

interface StringService {
    fun getString(@StringRes stringResourceId: Int): String
}