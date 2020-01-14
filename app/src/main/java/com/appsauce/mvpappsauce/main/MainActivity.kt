package com.appsauce.mvpappsauce.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsauce.mvpappsauce.R
import com.appsauce.mvpappsauce.app.App
import com.appsauce.mvpappsauce.module.PresenterModule
import com.bluelinelabs.conductor.Conductor
import kotlinx.android.synthetic.main.activity_main.conductorContainer

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.setRouter(Conductor.attachRouter(this, conductorContainer, savedInstanceState))
        presenter = PresenterModule.main(this)
        presenter.viewReady()
    }

    override fun onDestroy() {
        presenter.destroy()
        App.setRouter(null)
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (!presenter.handleBack()) {
            super.onBackPressed()
        }
    }
}
