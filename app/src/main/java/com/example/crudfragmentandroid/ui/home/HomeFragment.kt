package com.example.crudfragmentandroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.FragmentHomeBinding
import com.example.crudfragmentandroid.dto.labelproduct.LabelProduct
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import com.example.crudfragmentandroid.ui.add.AddFragment
import com.example.crudfragmentandroid.ui.home.adapter.HomeAdapter


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
        Log.i("HOLA", "FRAGMENT HOME")

        initRecyclerView()

        binding.homeSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterProducts(newText)
                return true
            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun filterProducts(query: String?) {
        query?.let { searchTerm ->
            val filteredList = ProductRepository.returnProductList().filter { product ->
                // Filtrar por el nombre del producto o por los nombres de las etiquetas
                product.name.contains(searchTerm, ignoreCase = true) || product.label.any { label ->
                    label.name.contains(searchTerm, ignoreCase = true)
                }
            }
            adapter.updateData(filteredList)
        }
    }


    fun initRecyclerView() {
        adapter = HomeAdapter(
            ProductRepository.returnProductList()
        )
        binding.rvProduct.adapter = adapter
    }

}

