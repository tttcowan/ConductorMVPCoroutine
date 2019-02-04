package com.appsauce.mvpappsauce.dialog

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class DialogId(val asString: String) : Parcelable {

    DEFAULT("DEFAULT");
}