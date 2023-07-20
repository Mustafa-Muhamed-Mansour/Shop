package com.shop.repository

import com.shop.network.remote.ShopService
import com.shop.response.ShopResponse
import javax.inject.Inject

class ShopRepository @Inject constructor(
    private val shopService: ShopService
) {



    suspend fun fetchAllProduct(): ShopResponse {
        return shopService.fetchProducts()
    }


}