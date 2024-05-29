package com.example.crudfragmentandroid.ui.delete

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.FragmentDeleteBinding
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import com.example.crudfragmentandroid.ui.delete.adapter.recyclerdelete.AdapterDelete


class DeleteFragment : Fragment() {
    private lateinit var binding: FragmentDeleteBinding
    private val listCar = ProductRepository.returnProductCar()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentDeleteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        Log.i("HOLA","FRAGMENT DELETE")

        if (listCar.isEmpty()) {
            binding.recyclerDelete.visibility = View.GONE
            binding.cvDetailDelete.visibility = View.GONE
            binding.tvTitle.text = "No items loaded"
        } else {
            initRecyclerDelete(listCar)
            binding.recyclerDelete.visibility = View.VISIBLE
            binding.cvDetailDelete.visibility = View.VISIBLE
            binding.tvTitle.text = "Checkout"
            printMount()
            binding.checkout.setOnClickListener {
                listCar.forEach { it
                    ProductRepository.deleteProductCar(it.first)
                }
                findNavController().navigate(R.id.action_deleteFragment_to_nav_home)
            }

        }

    }
    fun printMount(){
        var mount = 0.0F
        listCar.forEach {
           mount = it.first.cout * it.second
        }
        binding.tvSubtotalProductPrice.text = "$ ${"%.2f".format(mount)}"
        binding.tvTotalBuyPrice.text = "$ ${"%.2f".format(mount + 15)}"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }
    fun initRecyclerDelete(list: MutableList<Pair<Product, Int>>){
      val adapterDelete = AdapterDelete(
          list
      )
      binding.recyclerDelete.adapter = adapterDelete
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}