package com.example.crudfragmentandroid.ui.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.FragmentDeleteBinding
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.ui.delete.adapter.recyclerdelete.AdapterDelete


class DeleteFragment : Fragment() {
    private lateinit var binding: FragmentDeleteBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentDeleteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        initRecyclerDelete()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root

    }
    fun initRecyclerDelete(){
      //  val adapterDelete = AdapterDelete()
      //  binding.recyclerDelete.adapter = adapterDelete
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fbBack.setOnClickListener {
            findNavController().navigate(R.id.action_deleteFragment_to_nav_home)
        }
    }

}