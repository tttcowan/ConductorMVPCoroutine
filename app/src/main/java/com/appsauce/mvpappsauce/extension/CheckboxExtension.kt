package com.appsauce.mvpappsauce.extension

import android.widget.CheckBox

fun CheckBox.checkListener(checked: (check: Boolean) -> Unit) {
    setOnCheckedChangeListener { _, isChecked -> checked(isChecked) }
}