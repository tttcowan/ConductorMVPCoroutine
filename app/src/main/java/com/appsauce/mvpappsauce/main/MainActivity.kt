package com.appsauce.mvpappsauce.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.appsauce.mvpappsauce.R
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.appsauce.mvpappsauce.navigation.NavigationServiceProd
import com.bluelinelabs.conductor.Conductor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var navigationService: NavigationService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val router = Conductor.attachRouter(this, conductorContainer, savedInstanceState)
        navigationService = NavigationServiceProd(router)
        navigationService.toHome()
    }

    override fun onDestroy() {
        navigationService.destroy()
        super.onDestroy()
    }
}
