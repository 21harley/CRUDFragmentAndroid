package com.example.crudfragmentandroid.ui.delete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }
    fun initRecyclerDelete(){
      //  val adapterDelete = AdapterDelete()
      //  binding.recyclerDelete.adapter = adapterDelete
    }


}