package com.example.crudfragmentandroid.ui.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.FragmentAddBinding
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.ui.add.recycleradd.RecyclerViewAdd
import com.example.crudfragmentandroid.ui.add.recycleradd.ViewHolderAdd
import com.example.crudfragmentandroid.ui.home.HomeFragment.Companion.valueItem


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerViewAdd: RecyclerViewAdd
    private lateinit var productOne:Product
    private  var adoptllmanager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddBinding.inflate(inflater, container, false)

        val listProduct = data()
        productOne = listProduct[0]
        initRecyclerView(listProduct)

        //click images

        updateView(productOne)
        binding.likebutton.setOnClickListener{
            Log.i("HOLA",productOne.like.toString())
            val heart = if(!productOne.like) R.drawable.heart2 else R.drawable.heart1
            binding.likebutton.setBackgroundResource(heart)
            productOne.like=!productOne.like
        }

        // Inflate the layout for this fragment
        binding.textViewNameProduct.text = valueItem
        return binding.root

    }
    private fun updateView(p:Product){
        //heart
        val heart = if(p.like) R.drawable.heart2 else R.drawable.heart1
        binding.likebutton.setBackgroundResource(heart)
        binding.likebutton.setOnClickListener{
            Log.i("HOLA",productOne.like.toString())
            val heart = if(!productOne.like) R.drawable.heart2 else R.drawable.heart1
            binding.likebutton.setBackgroundResource(heart)
            productOne.like=!productOne.like
        }

        //name producto
        binding.textViewNameProduct.text = p.name

        //count product
        "$ ${p.cout} ".also { binding.textViewCout.text = it }

        //load full img
        Glide
            .with(this)
            .load(productOne.urlImg)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageViewFullProduct);

    }

    fun initRecyclerView(list: MutableList<Product>){
        recyclerViewAdd = RecyclerViewAdd(list)
        binding.recyclerViewProductAdd.adapter = recyclerViewAdd
        binding.recyclerViewProductAdd.layoutManager = adoptllmanager
    }



    fun data():MutableList<Product>{
        val listProduct = mutableListOf(
            Product(
                "dfsfsdf",
                "Zapato*A",
                10,
                249.99F,
                "Zapatos deportivos de alta calidad",
                false,
                4.2F,
                "AAA",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "dfsfsdf",
                "Zapato*A",
                10,
                249.99F,
                "Zapatos deportivos de alta calidad",
                false,
                4.2F,
                "AAA",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "dfsfsdf",
                "Zapato*A",
                10,
                249.99F,
                "Zapatos deportivos de alta calidad",
                false,
                4.2F,
                "AAA",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "dfsfsdf",
                "Zapato*A",
                10,
                249.99F,
                "Zapatos deportivos de alta calidad",
                false,
                4.2F,
                "AAA",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "dfsfsdf",
                "Zapato*A",
                10,
                249.99F,
                "Zapatos deportivos de alta calidad",
                false,
                4.2F,
                "AAA",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            ),
            Product(
                "dfsfsdf",
                "Zapato*A",
                10,
                249.99F,
                "Zapatos deportivos de alta calidad",
                false,
                4.2F,
                "AAA",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7BAAJ3_FAJGIn1-5TnEGZA09sW1Q6qKquHYU5KBcpw&s",
                mutableListOf(
                    LabelProduct("Zapato")
                )
            )
        )
        return listProduct
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}