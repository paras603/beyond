package com.example.beyond.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beyond.databinding.ItemNeoBinding
import com.example.beyond.model.Neo
import com.bumptech.glide.Glide

class NeoAdapter : ListAdapter<Neo, NeoAdapter.NeoViewHolder>(NeoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NeoViewHolder {
        val binding = ItemNeoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NeoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NeoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NeoViewHolder(private val binding: ItemNeoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(neo: Neo) {
            binding.tvNeoName.text = "Name: ${neo.name}"
            binding.tvNeoSize.text = "Size (Max): ${neo.estimated_diameter.kilometers.estimated_diameter_max} km"
            binding.tvNeoMagnitude.text = "Magnitude: ${neo.absolute_magnitude_h}"

            // You can add an image here if needed, e.g., from a URL or local assets
            // Glide.with(binding.ivNeo.context)
            //    .load(imageUrl) // Replace with image URL if available
            //    .into(binding.ivNeo)
        }
    }

    class NeoDiffCallback : DiffUtil.ItemCallback<Neo>() {
        override fun areItemsTheSame(oldItem: Neo, newItem: Neo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Neo, newItem: Neo): Boolean {
            return oldItem == newItem
        }
    }
}
