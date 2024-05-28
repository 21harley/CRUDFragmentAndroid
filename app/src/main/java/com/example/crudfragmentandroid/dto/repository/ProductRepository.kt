package com.example.crudfragmentandroid.dto.repository

import com.example.crudfragmentandroid.dto.ProductMock
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product

object ProductRepository {
    private var productList:MutableList<Product> = data()
    private var productCar:MutableList<Pair<Product,Int>>  = mutableListOf()
    private var labelProductList:MutableList<LabelProduct> = mutableListOf()


    var productSelection: Product? =null
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
            ),
            Product(
                "00001",
                "Nike AF1",
                50,
                150.000F,
                "Color: \n" +
                        "Negro\n" +
                        "Estilo: DV0788-100\n" +
                        "Origen: \n" + "Vietnam",
                false,
                4.3F,
                "Nike",
                "https://www.digitalsport.com.ar/files/products/5aa2b5a2a073f-436322-1200x1200.jpg",
                mutableListOf(
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00001",
                "Nike AF1",
                50,
                150.000F,
                """
                Color: 
                Blanco/Blanco/Gris Lobo
                Estilo: DV0788-100
                Origen: Vietnam
                """.trimIndent(),
                false,
                4.3F,
                "Nike",
                "https://nikearprod.vtexassets.com/arquivos/ids/659742-800-800?width=800&height=800&aspect=true",
                mutableListOf(
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00002",
                "Adidas Ultraboost",
                30,
                180.000F,
                """
                Color: 
                Negro/Negro/Blanco
                Estilo: GY6238
                Origen: China
            """.trimIndent(),
                true,
                4.7F,
                "Adidas",
                "https://s3.sa-east-1.amazonaws.com/www.vaypol.com.ar/variants/im105x3xtehbedr2tx8glva8kgwz/c77c2a06864ac9aca38dc5bd9371de015471edcdbf322dfb14411689bf968ae5",
                mutableListOf(
                    LabelProduct("Sport"),
                    LabelProduct("Running")

                )
            ),
            Product(
                "00003",
                "Puma RS-X",
                20,
                120.000F,
                """
                Color: 
                Blanco/Azul/Rojo
                Estilo: 374758-02
                Origen: India
            """.trimIndent(),
                true,
                4.5F,
                "Puma",
                "https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa/global/374758/02/sv01/fnd/PNA/fmt/png",
                mutableListOf(
                    LabelProduct("Running"),
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00004",
                "New Balance 574",
                40,
                140.000F,
                """
                Color: 
                Gris/Blanco
                Estilo: ML574EGK
                Origen: Vietnam
            """.trimIndent(),
                false,
                4.6F,
                "New Balance",
                "https://img.eobuwie.cloud/eob_product_656w_656h(6/d/a/a/6daa2188c3eccf0252c45d7e5c29ce914e22a50f_0000200627724_02_ws_1,jpg)/sneakers-new-balance-ml574lpk-negro.jpg",
                mutableListOf(
                    LabelProduct("Port")
                )
            ),
            Product(
                "00025",
                "Reebok Classic",
                25,
                130.000F,
                """
                Color: 
                Blanco/Blanco/Negro
                Estilo: FV1590
                Origen: Indonesia
            """.trimIndent(),
                true,
                4.4F,
                "Reebok",
                "https://reebokarg.vtexassets.com/arquivos/ids/212063-800-800?v=638419355996300000&width=800&height=800&aspect=true",
                mutableListOf(
                    LabelProduct("Casual")
                )
            ),
            Product(
                "00001",
                "Nike AF1",
                50,
                150.000F,
                """
                Color: 
                Blanco/Blanco/Gris Lobo
                Estilo: DV0788-100
                Origen: Vietnam
            """.trimIndent(),
                false,
                4.3F,
                "Nike",
                "https://nikearprod.vtexassets.com/arquivos/ids/699311/DH2920_001_A_PREM.jpg?v=638229667061330000",
                mutableListOf(
                    LabelProduct("Sport"),
                    LabelProduct("Casual")
                )

            ),
            Product(
                "00002",
                "Adidas Ultraboost",
                30,
                180.000F,
                """
                Color: 
                Negro/Negro/Blanco
                Estilo: GY6238
                Origen: China
            """.trimIndent(),
                true,
                4.7F,
                "Adidas",
                "https://ideacdn.net/idea/ab/68/myassets/products/845/adidas-erkek-ayakkabi-modelleri.jpg?revision=1711982636",
                mutableListOf(
                    LabelProduct("Running"),
                    LabelProduct("Sport")
                )

            ),
            Product(
                "00003",
                "Puma RS-X",
                20,
                120.000F,
                """
                Color: 
                Blanco/Gris
                Estilo: 374758-02
                Origen: India
            """.trimIndent(),
                true,
                4.5F,
                "Puma",
                "https://http2.mlstatic.com/D_920409-MLA76292513451_052024-O.jpg",
                mutableListOf(
                    LabelProduct("Sport"),
                    LabelProduct("Runnig")
                )
            ),
            Product(
                "00006",
                "Asics EX89",
                35,
                160.000F,
                """
                Color: 
                Blanco/Gris
                Estilo: 1011A767
                Origen: Japón
            """.trimIndent(),
                false,
                4.8F,
                "Asics",
                "https://b.scdn.gr/images/sku_main_images/050150/50150539/fixedratio_20240201213629_asics_ex89_andrika_sneakers_white_slate_grey_1201a476_117.jpeg",
                mutableListOf(
                    LabelProduct("Casual"),
                    LabelProduct("Classic")
                )

            ),
            Product(
                "00007",
                "Under Armour HOVR",
                28,
                170.000F,
                """
                Color: 
              Blanco/Rojo/Verde
                Estilo: 3021950
                Origen: Vietnam
            """.trimIndent(),
                true,
                4.6F,
                "Under Armour",
                "https://www.innovasport.com/medias/IS-3024271-106-4.jpg?context=bWFzdGVyfGltYWdlc3wxMjA1MTl8aW1hZ2UvanBlZ3xpbWFnZXMvaDFlL2hhYi8xMDcwODU2OTIyNzI5NC5qcGd8MTU0OGIyNWE1YmEzZTcwNTg0MGExMzk3NTllYzlhOTYyMjRlMzU3Nzc0NzIxYmRiMDkyMDU5MTVhNjJmM2EzOQ",
                mutableListOf(
                    LabelProduct("Running")
                )
            ),
            Product(
                "00008",
                "Saucony Jazz",
                22,
                140.000F,
                """
                Color: 
                Gris/Azul
                Estilo: 2044-367
                Origen: USA
            """.trimIndent(),
                false,
                4.5F,
                "Saucony",
                "https://cdn.shopify.com/s/files/1/0451/5456/6312/files/S70722-2_5.jpg?v=1696262778",
                mutableListOf(
                    LabelProduct("Zapato"),
                    LabelProduct("Classic")
                )

            ),
            Product(
                "00009",
                "Fila Disruptor II",
                45,
                110.000F,
                """
                Color: 
                Blanco
                Estilo: 5FM00544
                Origen: China
            """.trimIndent(),
                true,
                4.2F,
                "Fila",
                "https://fila.scene7.com/is/image/Fila/5FM00544?fmt=jpg&wid=800&hei=800&fit=fit,1&qlt=100,0",
                mutableListOf(
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00010",
                "Converse Chuck Taylor",
                60,
                90.000F,
                """
                Color: 
                Negro/Blanco
                Estilo: M9160
                Origen: USA
            """.trimIndent(),
                false,
                4.7F,
                "Converse",
                "https://converse.scene7.com/is/image/Converse/M9160?fmt=jpg&wid=800&hei=800&fit=fit,1&qlt=100,0",
                mutableListOf(
                    LabelProduct("Zapato")
                )

            ),
            Product(
                "00011",
                "Nike AF1",
                50,
                150.000F,
                """
                Color: 
                Blanco/Blanco/Gris Lobo
                Estilo: DV0788-100
                Origen: Vietnam
            """.trimIndent(),
                false,
                4.3F,
                "Nike",
                "https://m.media-amazon.com/images/I/61bFNDVpfxL._AC_SL1500_.jpg",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "00012",
                "Nike Air Max 270",
                40,
                180.000F,
                """
                Color: 
                Negro/Blanco
                Estilo: AH8050-002
                Origen: China
            """.trimIndent(),
                true,
                4.8F,
                "Nike",
                "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/fb5ef086-0e67-4f45-9c8e-6f6c1b90f9d6/air-max-270-mens-shoes-KkLcGR.png",
                mutableListOf(
                    LabelProduct("Zapatillas"),
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00013",
                "Nike Dunk Low",
                35,
                120.000F,
                """
                Color: 
                Blanco/Negro
                Estilo: DD1391-100
                Origen: Vietnam
            """.trimIndent(),
                true,
                4.7F,
                "Nike",
                "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/fe76c68d-4bb6-4f08-ae6a-9b5e2e450e8d/dunk-low-mens-shoes-DD1391-100.png",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "00014",
                "Air Jordan 1 Mid",
                50,
                160.000F,
                """
                Color: 
                Negro/Rojo
                Estilo: 554724-066
                Origen: China
            """.trimIndent(),
                false,
                4.6F,
                "Jordan",
                "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/52cf8c1a-0a37-4b8b-9bb2-84b8c0333dc0/air-jordan-1-mid-mens-shoes-8GSFj4.png",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "00015",
                "Air Jordan 4 Retro",
                30,
                200.000F,
                """
                Color: 
                Blanco/Cement Grey
                Estilo: 308497-103
                Origen: Vietnam
            """.trimIndent(),
                true,
                4.9F,
                "Jordan",
                "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/cd85d4cf-3e28-43e4-8206-3dff3feacb7b/air-jordan-4-retro-mens-shoes-308497-103.png",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "00016",
                "Vans Old Skool",
                60,
                100.000F,
                """
                Color: 
                Negro/Blanco
                Estilo: VN000D3HNVY
                Origen: Vietnam
            """.trimIndent(),
                true,
                4.5F,
                "Vans",
                "https://www.vans.com/media/catalog/product/6/0/600200160.jpg",
                mutableListOf(
                    LabelProduct("Zapatillas de moda")
                )
            ),
            Product(
                "00017",
                "Vans Sk8-Hi",
                40,
                120.000F,
                """
                Color: 
                Negro/Blanco
                Estilo: VN000D5IB8C
                Origen: China
            """.trimIndent(),
                false,
                4.7F,
                "Vans",
                "https://www.vans.com/media/catalog/product/6/0/600200200.jpg",
                mutableListOf(
                    LabelProduct("Zapatillas de moda"),
                    LabelProduct("Sport")

                )
            ),
            Product(
                "00018",
                "Vans Slip-On",
                50,
                80.000F,
                """
                Color: 
                Blanco/Negro
                Estilo: VN000EYEBWW
                Origen: China
            """.trimIndent(),
                true,
                4.6F,
                "Vans",
                "https://www.vans.com/media/catalog/product/6/0/600200140.jpg",
                mutableListOf(
                    LabelProduct("Zapatillas de moda")
                )
            ),
            Product(
                "00019",
                "Reebok Pump",
                35,
                130.000F,
                """
                Color: 
                Negro/Azul
                Estilo: RP001
                 Origen: Vietnam
                """.trimIndent(),
                true,
                4.4F,
                "Reebok",
                "https://s3.sa-east-1.amazonaws.com/www.vaypol.com.ar/variants/qmpc7yuh047jv949etsoohez9po6/c77c2a06864ac9aca38dc5bd9371de015471edcdbf322dfb14411689bf968ae5",
                mutableListOf(
                    LabelProduct("Zapatilla"),
                    LabelProduct("Reebok"),
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00019",
                "Reebok Pump",
                35,
                130.000F,
                """
                Color: 
                 Blanco/Azul
                  Estilo: RP001
                 Origen: Vietnam
                  """.trimIndent(),
                true,
                4.4F,
                "Reebok",
                "https://media.sivasdescalzo.com/media/catalog/product/H/R/HR0035_sivasdescalzo-Reebok-PUMP_OMNI_ZONE_II-1661768102-1.jpg?quality=70&auto=webp&fit=bounds&width=420",
                mutableListOf(
                    LabelProduct("Zapatilla"),
                    LabelProduct("Reebok"),
                    LabelProduct("Sport")
                )
            ),
            Product(
                "00020",
                "Reebok Pump",
                35,
                130.000F,
                """
                 Color: 
                Blanco/Azul
                  Estilo: RP001
                Origen: Vietnam
                  """.trimIndent(),
                true,
                4.4F,
                "Reebok",
                "https://m.media-amazon.com/images/I/51mkQlHP4JL._AC_SL1100_.jpg",
                mutableListOf(
                    LabelProduct("Zapatilla"),
                    LabelProduct("Reebok"),
                    LabelProduct("Sport")
                )
            )
        )
        return listProduct
    }
}
