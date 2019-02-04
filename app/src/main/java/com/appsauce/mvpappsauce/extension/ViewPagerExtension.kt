package com.appsauce.mvpappsauce.extension

import android.support.v4.view.ViewPager

fun ViewPager.pageSelected(updatePos: (pos: Int) -> Unit) {

    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            updatePos(position)
        }
    })
}