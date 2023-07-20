package com.shop.network.remote

import com.shop.other.Constant.Companion.END_POINT
import com.shop.response.ShopResponse
import retrofit2.http.GET

interface ShopService {


    @GET(END_POINT)
    suspend fun fetchProducts(): ShopResponse

}