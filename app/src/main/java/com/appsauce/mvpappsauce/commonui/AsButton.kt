package com.appsauce.mvpappsauce.commonui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class AsButton : AppCompatButton {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
    }
}