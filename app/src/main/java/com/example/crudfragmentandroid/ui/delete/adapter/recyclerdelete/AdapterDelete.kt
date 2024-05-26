package com.example.crudfragmentandroid.ui.delete.adapter.recyclerdelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.ItemRecyclerviewDeleteBinding
import com.example.crudfragmentandroid.dto.producto.Product

class AdapterDelete(val listDelete: MutableList<Product>) :
    RecyclerView.Adapter<ViewHolderDelete>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDelete {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_delete, parent, false)
        return ViewHolderDelete(view)
    }

    override fun getItemCount(): Int {
        return listDelete.size
    }

    override fun onBindViewHolder(holder: ViewHolderDelete, position: Int) {
        holder.render(listDelete[position])
    }
}

class ViewHolderDelete(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemRecyclerviewDeleteBinding.bind(view)
    fun render(data: Product) {

        binding.btnAdd.setOnClickListener {
            data.amount += 1
        }
        binding.btnRemove.setOnClickListener {
            if (data.amount < 0) data.amount -= 1
        }
        //aqui añadir Picasso para mostrar imagen en el recycler


    }
}

