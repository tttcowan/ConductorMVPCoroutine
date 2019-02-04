package com.appsauce.mvpappsauce.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadFromUrl(url: String, centreCrop: Boolean = false) {
    var glide = Glide.with(this).load(url)
    if (centreCrop) {
        glide = glide.apply(RequestOptions().centerCrop())
    }
    glide.into(this)
}