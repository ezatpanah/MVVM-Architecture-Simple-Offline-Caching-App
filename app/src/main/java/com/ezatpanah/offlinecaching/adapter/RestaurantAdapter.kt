package com.ezatpanah.offlinecaching.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ezatpanah.offlinecaching.databinding.RestaurantItemBinding
import com.ezatpanah.offlinecaching.response.RestaurantResponse
import javax.inject.Inject

class RestaurantAdapter @Inject constructor(): ListAdapter<RestaurantResponse, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffUtils( )) {

    private lateinit var binding: RestaurantItemBinding
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        binding = RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return RestaurantViewHolder()
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class RestaurantViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurantResponse: RestaurantResponse) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurantResponse.logo)
                    .into(imgLogo)
                tvName.text = restaurantResponse.name
                tvType.text = restaurantResponse.type
                tvAddress.text = restaurantResponse.address
            }
        }
    }

    class RestaurantDiffUtils : DiffUtil.ItemCallback<RestaurantResponse>() {
        override fun areItemsTheSame(oldItem: RestaurantResponse, newItem: RestaurantResponse) = oldItem.name == newItem.name
        override fun areContentsTheSame(oldItem: RestaurantResponse, newItem: RestaurantResponse) = oldItem == newItem
    }

}