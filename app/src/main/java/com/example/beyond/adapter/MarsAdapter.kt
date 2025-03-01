package com.example.beyond.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beyond.databinding.ItemMarsPhotoBinding
import com.example.beyond.model.MarsPhoto

class MarsAdapter : ListAdapter<MarsPhoto, MarsAdapter.MarsViewHolder>(MarsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        val binding = ItemMarsPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MarsViewHolder(private val binding: ItemMarsPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: MarsPhoto) {
            binding.tvRoverName.text = "Rover: ${photo.rover.name}"
            binding.tvCameraName.text = "Camera: ${photo.camera.full_name}"
            binding.tvDate.text = "Date: ${photo.earth_date}"

            Glide.with(binding.ivMarsPhoto.context)
                .load(photo.img_src)
                .into(binding.ivMarsPhoto)
        }
    }

    class MarsDiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem == newItem
        }
    }
}
