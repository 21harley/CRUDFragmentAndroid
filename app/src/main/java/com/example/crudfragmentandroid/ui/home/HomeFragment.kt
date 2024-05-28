package com.example.crudfragmentandroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.util.Util
import com.example.crudfragmentandroid.databinding.FragmentHomeBinding
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import com.example.crudfragmentandroid.ui.add.AddFragment
import com.example.crudfragmentandroid.ui.home.adapter.HomeAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listProduct = ProductRepository.returnProductList()


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    val navigation = fun(text: String) {
        val intent = Intent(context, AddFragment::class.java)
        startActivity(intent)
    }
}
/*
    fun observer(){
        binding.rvProduct.setOnClickListener{
            navigation()
        }
    }
    fun OnItemCick(position:Int){
      //  val selectImgProduct = li


    }
    fun initRecyclerView(){
        //val adapter = HomeAdapter()
        //binding.rvProduct.adapter
    }
}
*/
