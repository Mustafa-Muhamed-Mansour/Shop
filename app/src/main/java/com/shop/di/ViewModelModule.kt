package com.shop.di

import com.shop.home.ShopViewModel
import com.shop.repository.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {


    @Provides
    @Singleton
    fun fetchAllProduct(shopRepository: ShopRepository): ShopViewModel {
        return ShopViewModel(shopRepository)
    }

}