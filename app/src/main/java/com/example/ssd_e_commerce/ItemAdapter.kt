// ItemAdapter.kt
package com.example.ssd_e_commerce

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ssd_e_commerce.databinding.ItemCardBinding

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemName.text = item.name
            binding.itemPrice.text = "Price: $${item.price}"

            binding.root.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, ItemDetailActivity::class.java)
                intent.putExtra("ITEM", item)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}