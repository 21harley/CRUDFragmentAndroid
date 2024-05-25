package com.example.crudfragmentandroid.ui.add.recycleradd

import androidx.recyclerview.widget.RecyclerView
import com.example.crudfragmentandroid.dto.producto.Product
import android.view.View
import com.example.crudfragmentandroid.databinding.ItemRecyclerviewAddBinding


class ViewHolderAdd(private val view: View):RecyclerView.ViewHolder(view) {
    val binding=ItemRecyclerviewAddBinding.bind(view)
    fun render(item:Product){

    }

}