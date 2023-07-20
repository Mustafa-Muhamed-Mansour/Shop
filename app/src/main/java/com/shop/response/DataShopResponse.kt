package com.shop.response

import com.google.gson.annotations.SerializedName
import com.shop.model.ShopModel

data class DataShopResponse(
    @SerializedName("data")
    val data: List<ShopModel>
)