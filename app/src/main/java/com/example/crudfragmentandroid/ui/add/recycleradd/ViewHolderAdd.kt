package com.example.crudfragmentandroid.ui.add.recycleradd

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfragmentandroid.dto.producto.Product
import android.view.View
import com.bumptech.glide.Glide
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.ItemRecyclerviewAddBinding


class ViewHolderAdd(private val view: View):RecyclerView.ViewHolder(view) {
    private val binding=ItemRecyclerviewAddBinding.bind(view)
    fun render(item:Product){
        Glide
            .with(view)
            .load(item.urlImg)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imageView2);
    }

}