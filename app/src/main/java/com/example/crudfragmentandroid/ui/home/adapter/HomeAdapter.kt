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

class HomeAdapter(private var myList: List<Product>,private val nav: (String) -> Unit ): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_img, parent, false)
        return MyViewHolder(view)
    }
//    private val nav: () -> Unit nav
    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(myList[position],nav)
    }
}

class MyViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val binding= ItemHomeImgBinding.bind(view)
    fun render(product: Product,nav: (String) -> Unit ) {
        binding.price.text = product.cout.toString()
        binding.model.text = product.name
        binding.value.text = product.worth.toString()
        Picasso.get().load(product.urlImg).into(binding.img)
//
        binding.img.setOnClickListener { nav.invoke(product.name) }
    }
}