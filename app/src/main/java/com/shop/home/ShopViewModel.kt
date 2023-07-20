package com.shop.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shop.model.ShopModel
import com.shop.repository.ShopRepository
import com.shop.response.ShopResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val shopRepository: ShopRepository
) : ViewModel() {


//    private val _photoModel = MutableStateFlow(emptyList<PhotoModel>())
//    val photoModel: StateFlow<List<PhotoModel>> get() = _photoModel

    private val _shopData = MutableStateFlow(emptyList<ShopResponse>())
    val shopData = _shopData.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()


    init {
        fetchAllProducts()
    }

    private fun fetchAllProducts() {
        viewModelScope.launch {
            try {
                val shop = shopRepository.fetchAllProduct()
                _shopData.value = listOf(shop)
                Log.i("Fetch_Shopping", _shopData.value.toString())
            }catch (e: Exception) {
                _errorMessage.value = e.message.toString()
                Log.e("Error_Shopping", e.message.toString())
            }
        }
    }
}