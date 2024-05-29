package com.example.crudfragmentandroid.ui.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.FragmentAddBinding
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import com.example.crudfragmentandroid.ui.add.recycleradd.RecyclerViewAdd
import com.example.crudfragmentandroid.ui.core.customdialog.CustomDialog

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
    private var listProduct= ProductRepository.returnProductList().filter { it.like }.toMutableList()
    private lateinit var productOne:Product
    private var productQuantity=1
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

        Log.i("HOLA","FRAGMENT ADD")
        val navController = findNavController()

        if (listProduct.size>0) updateViewProducto()

        // Inflate the layout for this fragment
        return binding.root
    }
    fun updateViewProducto(){
        listProduct= ProductRepository.returnProductList().filter { it.like }.toMutableList()
        productOne = listProduct[0]
        initRecyclerView(listProduct)

        //click images

        updateView(productOne)
        binding.likebutton.setOnClickListener{
            Log.i("HOLA",productOne.like.toString())
            val heart = if(!productOne.like) R.drawable.heart2 else R.drawable.heart1
            binding.likebutton.setBackgroundResource(heart)
            productOne.like=!productOne.like
            ProductRepository.updateProductInList(productOne)
            updateViewProducto()
        }
    }
    fun initRecyclerView(list: MutableList<Product>){
        recyclerViewAdd = RecyclerViewAdd(list,call = {call(it)})
        binding.recyclerViewProductAdd.adapter = recyclerViewAdd
        binding.recyclerViewProductAdd.layoutManager = adoptllmanager
    }

    private fun call(i:Int){
        Log.i("HOLA",i.toString())
        productQuantity = 1
        productOne=listProduct[i]
        updateView(
           listProduct[i]
        )
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
            ProductRepository.updateProductInList(productOne)
            updateViewProducto()
        }

        //name producto
        binding.textViewNameProduct.text = p.name

        //count product
        "$ ${p.cout} ".also { binding.textViewCout.text = it }

        //description produt
        binding.textViewDescriptionProduct.text = p.description

        binding.textViewAmountAddProductText.text = p.worth.toString()
        //load full img
        Glide
            .with(this)
            .load(p.urlImg)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageViewFullProduct);

        if (p.amount>0){
            binding.containerCountProduct.visibility = View.VISIBLE
            binding.textErrorAmout.visibility = View.GONE
            binding.textViewAmountProduct.text = "1"
            binding.buttonAddProduct.setOnClickListener {
                if (productOne.amount>=productQuantity + 1){
                    Log.i("Hola","click"+productQuantity.toString())
                    Log.i("Hola","click"+productOne.amount.toString())
                    updateAmountIncrement(1)
                    val result = p.cout * productQuantity
                    binding.textViewCout.text = "$ ${"%.2f".format(result)}"
                }
            }

            binding.buttonDeleteProduct.setOnClickListener {
                if (productQuantity - 1> 0){
                    updateAmountIncrement(-1)
                    val result = p.cout * productQuantity
                    binding.textViewCout.text = "$ ${"%.2f".format(result)}"
                }
            }
        }else{
            binding.textErrorAmout.visibility = View.VISIBLE
            binding.containerCountProduct.visibility = View.GONE
        }



        binding.buttonDeleteProduct.setOnClickListener {
            if (productQuantity - 1> 0){
                updateAmountIncrement(-1)
                val result = p.cout * productQuantity
                binding.textViewCout.text = "$ ${"%.2f".format(result)}"
            }
        }

            binding.addToCart.setOnClickListener {
                if(productOne.amount>0){
                    val newProduct = productOne.clone()
                    newProduct.amount -= productQuantity
                    if(ProductRepository.updateProductList(productOne,newProduct)){
                        ProductRepository.addProductCar(productOne, productQuantity)
                        updateAmount(1)
                        listProduct= ProductRepository.returnProductList()
                        val pos = listProduct.indexOf(newProduct)
                        productOne = listProduct[pos]
                        updateView(productOne)
                    }
                    CustomDialog(
                        "Se agrego al carrito",
                        "pagar",
                        "continuar comprando",
                        {},{}
                    ).show(parentFragmentManager,"Init_Dialog_Maintenace")
                }else{
                    CustomDialog(
                        "Error",
                        "ir a pagar",
                        "continuar comprando",
                        {},{}
                    ).show(parentFragmentManager,"Init_Dialog_Maintenace")
                }

            }

    }

    fun updateAmountIncrement(value:Int){
        productQuantity+=value
        binding.textViewAmountProduct.text = productQuantity.toString()
    }
    fun updateAmount(value:Int){
        productQuantity=value
        binding.textViewAmountProduct.text = productQuantity.toString()
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