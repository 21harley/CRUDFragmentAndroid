package com.example.crudfragmentandroid.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.ItemHomeImgBinding
import com.example.crudfragmentandroid.dto.producto.Product
import com.example.crudfragmentandroid.dto.repository.ProductRepository
import com.squareup.picasso.Picasso

class HomeAdapter(private var myList: List<Product>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_img, parent, false)
        return MyViewHolder(view)
    }
//    private val nav: () -> Unit nav
    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(myList[position])
    }

    fun updateData(newList: List<Product>) {
        myList = newList
        //notifyDataSetChanged()
    }
}

class MyViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    private val binding= ItemHomeImgBinding.bind(view)
    fun render(product: Product) {
        with(binding) {
            price.text = product.cout.toString()
            model.text = product.name
            value.text = product.worth.toString()
            Picasso.get().load(product.urlImg).into(img)
            img.setOnClickListener {

            }

            val heart = if(product.like) R.drawable.heart2 else R.drawable.heart1
            imgHearLineGrey.setBackgroundResource(heart)

            imgHearLineGrey.setOnClickListener {
                val heart1 = if(!product.like) R.drawable.heart2 else R.drawable.heart1
                imgHearLineGrey.setBackgroundResource(heart1)
                product.like=!product.like
                ProductRepository.updateProductInList(product)
            }
        }
    }


}