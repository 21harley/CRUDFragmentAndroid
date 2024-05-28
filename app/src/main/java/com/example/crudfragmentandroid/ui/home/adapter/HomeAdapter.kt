package com.example.crudfragmentandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.ItemHomeImgBinding
import com.example.crudfragmentandroid.dto.dtohome.DataHomeItem
import com.example.crudfragmentandroid.dto.producto.Product
import com.squareup.picasso.Picasso

class HomeAdapter(private var myList: List<Product>, private val nav: () -> Unit ): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemHomeImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding, nav)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(myList[position])
    }
}

class MyViewHolder(private val binding: ItemHomeImgBinding, private val nav: () -> Unit) : RecyclerView.ViewHolder(binding.root) {
    fun render(product: Product) {
        binding.price.text = product.cout.toString()
        binding.model.text = product.name
        binding.value.text = product.worth.toString()
        Picasso.get().load(product.urlImg).into(binding.img)

        binding.img.setOnClickListener { nav.invoke() }
    }
}