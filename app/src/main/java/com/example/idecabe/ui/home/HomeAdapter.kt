package com.example.idecabe.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.databinding.ItemProjectBinding

class HomeAdapter(
    val onItemClicked: (Int, Project) -> Unit,
): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    //Inputan List Items
    private var listItems: MutableList<Project> = arrayListOf()

    inner class MyViewHolder(val binding: ItemProjectBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Project){
            binding.projectName.text = item.project_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listItems[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}