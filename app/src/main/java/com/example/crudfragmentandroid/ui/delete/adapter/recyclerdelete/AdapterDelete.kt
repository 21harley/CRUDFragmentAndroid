package com.example.crudfragmentandroid.ui.delete.adapter.recyclerdelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crudfragmentandroid.R
import com.example.crudfragmentandroid.databinding.ItemRecyclerviewDeleteBinding
import com.example.crudfragmentandroid.dto.producto.Product

class AdapterDelete(val listDelete: MutableList<Pair<Product,Int>>) :
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

class ViewHolderDelete(private val view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemRecyclerviewDeleteBinding.bind(view)
    fun render(data: Pair<Product,Int>) {

        Glide
            .with(view)
            .load(data.first.urlImg)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivProduct);

        binding.tvNameProduct.text = data.first.name

        binding.tvSize.text = data.first.brand

        binding.tvCountEdit.text = data.second.toString()

        val resultado = data.second * data.first.cout
        binding.tvPrice.text = "$ ${"%.2f".format(resultado)}"

        binding.btnAdd.visibility = View.GONE
        binding.btnRemove.visibility = View.GONE

    }
}

