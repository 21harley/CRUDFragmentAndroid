package com.example.crudfragmentandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudfragmentandroid.dto.dtohome.DataHomeItem
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(): ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage
    private fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val productList = ProductRepository.getProducts()
            if (productList.isNotEmpty()) {
                _products.postValue(productList)
            } else {
                _errorMessage.postValue("Error")
            }
        }
    }
}