package com.example.unitapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.unitapp.databinding.UnitViewHolderBinding
import com.example.unitapp.models.Data

class PropertyListAdapter(private val data: List<Data>, private val callback: NavigateInterface) :
    RecyclerView.Adapter<PropertyViewHolder>() {

    interface NavigateInterface{
        fun showDetailScreen(id: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val binding =
            UnitViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PropertyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        data[position].property_images.forEach { image ->
            val imageView = AppCompatImageView(holder.itemView.context)
            Glide.with(holder.itemView.context)
                .load(image.attachment.medium.url)
                .override(Target.SIZE_ORIGINAL, 700)
                .into(imageView)
            holder.binding.unitImageLayout.addView(imageView)
        }

        holder.binding.unitTitle.text = data[position].agent.company_name
        holder.binding.unitAddress.text = data[position].location.address
        Glide.with(holder.itemView.context)
            .load(data[position].agent.avatar.small.url)
            .override(300, 300)
            .fitCenter()
            .into(holder.binding.agentImage)
        holder.binding.bedCount.text = data[position].bedrooms.toString()
        holder.binding.bathCount.text = data[position].bathrooms.toString()
        holder.binding.carCount.text = data[position].carspaces.toString()
        holder.binding.listItem.setOnClickListener {
            callback.showDetailScreen(data[position].id)
        }
    }

    override fun getItemCount() = data.size
}
