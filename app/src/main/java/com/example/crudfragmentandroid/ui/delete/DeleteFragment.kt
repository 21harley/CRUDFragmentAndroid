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
import com.example.crudfragmentandroid.ui.core.customdialog.CustomDialog
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
            "No items loaded".also { binding.tvTitle.text = it }
        } else {
            initRecyclerDelete(listCar)
            binding.recyclerDelete.visibility = View.VISIBLE
            binding.cvDetailDelete.visibility = View.VISIBLE
            "Checkout".also { binding.tvTitle.text = it }
            printMount()
            binding.checkout.setOnClickListener {
                ProductRepository.deleteProductCar()
                findNavController().navigate(R.id.action_deleteFragment_to_nav_home)
                CustomDialog(
                    "Su compra exitosa! :D",
                    "KO",
                    "",
                    {},{}
                ).show(parentFragmentManager,"Init_Dialog_Maintenace")
            }

        }

    }
    private fun printMount(){
        var mount = 0.0F
        listCar.forEach {
           mount = it.first.cout * it.second
        }
        "$ ${"%.2f".format(mount)}".also { binding.tvSubtotalProductPrice.text = it }
        "$ ${"%.2f".format(mount + 15)}".also { binding.tvTotalBuyPrice.text = it }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }
    private fun initRecyclerDelete(list: MutableList<Pair<Product, Int>>){
      val adapterDelete = AdapterDelete(
          list
      )
      binding.recyclerDelete.adapter = adapterDelete
    }


}