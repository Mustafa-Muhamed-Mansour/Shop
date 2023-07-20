package com.shop.response

import com.google.gson.annotations.SerializedName

data class ShopResponse(
    @SerializedName("data")
    val dataShopResponse: DataShopResponse
)