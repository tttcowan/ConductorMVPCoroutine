package com.appsauce.mvpappsauce.dialog

import android.os.Parcel
import android.os.Parcelable

enum class DialogId(val asString: String) : Parcelable {

    DEFAULT("DEFAULT");

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(asString)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DialogId> {

        private val map = DialogId.values().associateBy { it.asString }
        fun fromName(name: String): DialogId {
            return map[name] ?: DEFAULT
        }

        override fun createFromParcel(parcel: Parcel): DialogId {
            return fromName(parcel.readString())
        }

        override fun newArray(size: Int): Array<DialogId?> {
            return arrayOfNulls(size)
        }
    }

}