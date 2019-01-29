package com.appsauce.mvpappsauce.extension

fun Any.tag(): String {
    return this::class.java.simpleName
}
