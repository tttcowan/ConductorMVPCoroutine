package com.appsauce.mvpappsauce.extension

import android.widget.Toast
import com.appsauce.mvpappsauce.app.App


fun String.toast() {
    Toast.makeText(App.context(), this, Toast.LENGTH_LONG).show()
}