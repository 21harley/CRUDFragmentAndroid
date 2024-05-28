package com.example.crudfragmentandroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.FragmentHomeBinding
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.ui.add.AddFragment
import com.example.crudfragmentandroid.ui.home.adapter.HomeAdapter
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    companion object {
        var valueItem = ""
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

    }


    fun initRecyclerView() {
        adapter = HomeAdapter(data()) {
            navigation(it)
        }
        binding.rvProduct.adapter = adapter
    }

    val navigation = fun(text: String) {
        val intent = Intent(context, AddFragment::class.java)
        valueItem = text
        startActivity(intent)
    }


    private fun data(): List<Product> {
        val products = listOf<Product>(
            Product(
                "00001",
                "Nike AF1",
                50,
                150.000F,
                "Color: \n" +
                        "Blanco/Blanco/Gris Lobo\n" +
                        "Estilo: DV0788-100\n" +
                        "Origen: \n" + "Vietnam",
                false,
                4.3F,
                "Nike",
                "https://nikearprod.vtexassets.com/arquivos/ids/659742-800-800?width=800&height=800&aspect=true"
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
                "https://assets.adidas.com/images/w_600,f_auto,q_auto/ef8f64d290e8460192d6ac8400af8a98_9366/Ultraboost_22_Zapatos_Negro_GY6238_01_standard.jpg"
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
                "https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa/global/374758/02/sv01/fnd/PNA/fmt/png"

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
                "https://m.media-amazon.com/images/I/71H5JNSdhEL._AC_SL1500_.jpg"
            ),
            Product(
                "00005",
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
                "https://reebokarg.vtexassets.com/arquivos/ids/212063-800-800?v=638419355996300000&width=800&height=800&aspect=true"
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
                "https://assets.adidas.com/images/w_600,f_auto,q_auto/ef8f64d290e8460192d6ac8400af8a98_9366/Ultraboost_22_Zapatos_Negro_GY6238_01_standard.jpg",

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

                ),
            Product(
                "00006",
                "Asics Gel-Kayano",
                35,
                160.000F,
                """
                Color: 
                Negro/Gris
                Estilo: 1011A767
                Origen: Japón
            """.trimIndent(),
                false,
                4.8F,
                "Asics",
                "https://asics.scene7.com/is/image/asics/1011A767_001?fmt=jpg&wid=800&hei=800&fit=fit,1&qlt=100,0",

                ),
            Product(
                "00007",
                "Under Armour HOVR",
                28,
                170.000F,
                """
                Color: 
                Azul/Blanco
                Estilo: 3021950
                Origen: Vietnam
            """.trimIndent(),
                true,
                4.6F,
                "Under Armour",
                "https://underarmour.scene7.com/is/image/Underarmour/3021950?fmt=jpg&wid=800&hei=800&fit=fit,1&qlt=100,0",
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
                "https://saucony.scene7.com/is/image/Saucony/2044-367?fmt=jpg&wid=800&hei=800&fit=fit,1&qlt=100,0",

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

                ),
            Product(
                "00002",
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

                ),
            Product(
                "00003",
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

                ),
            Product(
                "00004",
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

                ),
            Product(
                "00005",
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

                ),
            Product(
                "00006",
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

                ),
            Product(
                "00007",
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
            ),
            Product(
                "00008",
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
                    LabelProduct("Zapato")
                )
            )
        )
        return products

    }
}