package com.example.crudfragmentandroid.dto.repository

import com.example.crudfragmentandroid.dto.ProductMock
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product

object ProductRepository {
    private var productList:MutableList<Product> = data()
    private var productCar:MutableList<Pair<Product,Int>>  = mutableListOf()
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
    // Agregar un producto al carrito
    fun addProductCar(product: Product, quantity: Int): Boolean {
        val index = productCar.indexOfFirst { it.first == product }
        return if (index != -1) {
            // Si el producto ya existe, actualizamos la cantidad
            productCar[index] = productCar[index].copy(second = productCar[index].second + quantity)
            true
        } else {
            // Si el producto no existe, lo añadimos al carrito
            productCar.add(Pair(product, quantity))
            false
        }
    }

    // Eliminar un producto del carrito
    fun deleteProductCar(product: Product): Boolean {
        val index = productCar.indexOfFirst { it.first == product }
        return if (index != -1) {
            productCar.removeAt(index)
            true
        } else {
            false
        }
    }

    // Retornar la lista de productos en el carrito
    fun returnProductCar(): MutableList<Pair<Product, Int>> {
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

    fun data(): MutableList<Product> {
        val listProduct = mutableListOf(
            Product(
                "1",
                "Zapato Deportivo A",
                20,
                299.99F,
                "Zapatos deportivos de alta calidad y confort",
                false,
                4.5F,
                "Deportivo",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Deportivo")
                )
            ),
            Product(
                "2",
                "Zapato Deportivo B",
                15,
                259.99F,
                "Zapatos deportivos con diseño innovador",
                false,
                4.7F,
                "Deportivo",
                "https://thursdayboots.com/cdn/shop/products/1024x1024-Men-Diplomat-Arizona-LB1_1024x1024_3d380701-4061-4988-9288-f3a1de702a46.jpg?v=1584559616&width=768",
                mutableListOf(
                    LabelProduct("Deportivo")
                )
            ),
            Product(
                "3",
                "Zapato Deportivo C",
                12,
                279.99F,
                "Zapatos deportivos de alto rendimiento",
                false,
                4.8F,
                "Deportivo",
                "https://thursdayboots.com/cdn/shop/products/1024x1024-Men-Diplomat-BlackMatte-LB1-4_1024x1024_516ce4b8-71c8-4397-a9ce-a88a603606ee.jpg?v=1584559834&width=768",
                mutableListOf(
                    LabelProduct("Deportivo")
                )
            ),
            Product(
                "4",
                "Zapato Deportivo D",
                18,
                249.99F,
                "Zapatos deportivos ligeros y cómodos",
                false,
                4.6F,
                "Deportivo",
                "https://i.ebayimg.com/images/g/u5MAAOSwD71lhUlQ/s-l960.webp",
                mutableListOf(
                    LabelProduct("Deportivo")
                )
            ),
            Product(
                "5",
                "Zapato Deportivo E",
                10,
                239.99F,
                "Zapatos deportivos con tecnología avanzada",
                false,
                4.4F,
                "Deportivo",
                "https://m.media-amazon.com/images/I/61HiUIABxKL._AC_SY535_.jpg",
                mutableListOf(
                    LabelProduct("Deportivo")
                )
            ),
            Product(
                "6",
                "Zapato Deportivo F",
                25,
                269.99F,
                "Zapatos deportivos para uso diario",
                false,
                4.9F,
                "Deportivo",
                "https://m.media-amazon.com/images/I/51qTBswsjNL._AC_SY535_.jpg",
                mutableListOf(
                    LabelProduct("Deportivo")
                )
            )
        )
        return listProduct
    }
}
