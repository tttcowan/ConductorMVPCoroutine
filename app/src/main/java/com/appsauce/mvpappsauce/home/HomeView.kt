package com.appsauce.mvpappsauce.home

import com.appsauce.mvpappsauce.base.BaseView

interface HomeView : BaseView {
    fun callComplete()
    fun dialogReturn()
}