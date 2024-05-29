package com.example.crudfragmentandroid.ui.add.recycleradd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.dto.producto.Product

class RecyclerViewAdd(
    private val list: MutableList<Product>,
    private val call: (Int) -> Unit
):RecyclerView.Adapter<ViewHolderAdd>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdd {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_add,parent,false)
        return ViewHolderAdd(view)
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderAdd, position: Int) {
        holder.render(list[position],call,position )
    }


}