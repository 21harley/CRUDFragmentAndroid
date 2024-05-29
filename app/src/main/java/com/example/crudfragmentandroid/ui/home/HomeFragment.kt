package com.example.crudfragmentandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.crudfragmentandroid.databinding.FragmentHomeBinding
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import com.example.crudfragmentandroid.ui.home.adapter.HomeAdapter
import okhttp3.internal.notifyAll


class HomeFragment : Fragment() {

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

        initRecyclerView(ProductRepository.returnProductList())

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
            }.toMutableList()
            initRecyclerView(filteredList)

        }
    }


    private fun initRecyclerView(list: MutableList<Product>) {
        adapter = HomeAdapter(
            list
        )
        binding.rvProduct.adapter = adapter
    }

}

