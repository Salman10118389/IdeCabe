package com.example.idecabe.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idecabe.R
import com.example.idecabe.databinding.ItemPhotoBinding
import com.example.idecabe.core.sources.remote.model.Photo
import java.util.ArrayList
@SuppressLint("NotifyDataSetChanged")
class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.viewHolder>() {
    private var data = ArrayList<Photo>()
    inner class viewHolder(private val itemPhotoBinding: ItemPhotoBinding): RecyclerView.ViewHolder(itemPhotoBinding.root){
        fun bind(item: Photo, position: Int){
            itemPhotoBinding.apply {
                val photo = item.photo
                if (photo != null) {
                    imageProdukCategory.setImageResource(photo)
                }else{
                    imageProdukCategory.setImageResource(R.drawable.ic_baseline_add_24)
                }
            }
        }
    }

    fun addItems(items: List<Photo>){
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context),
            parent
            , false))

    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}