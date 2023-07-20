package com.shop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopModel(
    var id: Int = 0,
    val image: String,
    val name: String,
    val description: String,
    val price: Double = 0.0
): Parcelable
