package com.shop.di

import com.shop.network.remote.ShopService
import com.shop.repository.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {



    @Provides
    @Singleton
    fun fetchAllProduct(shopService: ShopService): ShopRepository {
        return ShopRepository(shopService)
    }

}