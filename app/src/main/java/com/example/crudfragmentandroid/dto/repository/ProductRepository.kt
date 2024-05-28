package com.example.crudfragmentandroid.dto.repository

import com.example.crudfragmentandroid.dto.ProductMock
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product

object ProductRepository {
    private var productList:MutableList<Product> = mutableListOf()
    private var productCar:MutableList<Product>  = mutableListOf()
    private var labelProductList:MutableList<LabelProduct> = mutableListOf()

    //Product List
    fun addProductList(product: Product):Boolean{
        val status=productList.contains(product)
        return if(status) true else productList.add(product)
    }
    fun deleteProductList(product: Product):Boolean{
        val status=productList.contains(product)
        if(status){
            val pos = productList.indexOf(product)
            productList.removeAt(pos)
            return true
        }
        return  false
    }
    fun searchProductList(product: Product):Product?{
        val status= productList.contains(product)
        return if(status) productList[productList.indexOf(product)] else null
    }
    fun updateProductList(product: Product,newProduct: Product):Boolean{
        val status= productList.contains(product)
        if(status){
            productList[productList.indexOf(product)] = newProduct
            return true
        }
        return false
    }
    fun returnProductList(): MutableList<Product> {
        return productList
    }

    //Car list
    fun addProductCar(product: Product):Boolean{
        val status=productCar.contains(product)
        return if(status) true else productCar.add(product)
    }
    fun deleteProductCar(product: Product):Boolean{
        val status=productCar.contains(product)
        if(status){
            val pos = productCar.indexOf(product)
            productCar.removeAt(pos)
            return true
        }
        return  false
    }

    fun returnProductCar(): MutableList<Product> {
        return productCar
    }

    //Label List
    fun addLabelList(labelProduct: LabelProduct):Boolean{
        val status=labelProductList.contains(labelProduct)
        return if(status) true else labelProductList.add(labelProduct)
    }
    fun returnLabelProductList(): MutableList<LabelProduct> {
        return labelProductList
    }

    //homeProducto
    private val productMock = ProductMock()

    fun getProducts(): List<Product> {
        return productMock.getProducts()
    }
}
