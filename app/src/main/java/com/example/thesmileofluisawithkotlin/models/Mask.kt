package com.example.thesmileofluisawithkotlin.models

import android.content.ClipData
import android.os.Parcel
import android.os.Parcelable

class Mask : Parcelable {
    var name: String? = null
    var model: String? = null
    var price : Int = 0
    var img : Int? = null

    constructor(name: String?, model: String?, price: Int, img: Int) {
        this.name = name
        this.model = model
        this.price = price
        this.img = img
    }

    constructor() {}
    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        model = `in`.readString()
        price = `in`.readInt()
        img = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(model)
        dest.writeInt(price)
        img?.let { dest.writeInt(it) }
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Mask?> = object : Parcelable.Creator<Mask?> {
            override fun createFromParcel(`in`: Parcel): Mask? {
                return Mask(`in`)
            }

            override fun newArray(size: Int): Array<Mask?> {
                return arrayOfNulls(size)
            }
        }
    }
}