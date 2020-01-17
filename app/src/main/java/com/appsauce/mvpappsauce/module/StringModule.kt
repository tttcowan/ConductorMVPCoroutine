package com.appsauce.mvpappsauce.module

import com.appsauce.mvpappsauce.service.StringService
import com.appsauce.mvpappsauce.service.StringServiceProd

object StringModule {
    fun stringService(): StringService {
        return StringServiceProd()
    }
}