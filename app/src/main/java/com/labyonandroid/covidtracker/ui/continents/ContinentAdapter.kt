package com.labyonandroid.covidtracker.ui.continents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.labyonandroid.covidtracker.databinding.ContinentListBinding
import com.labyonandroid.covidtracker.model.ContinentData

class ContinentAdapter : ListAdapter<ContinentData, ContinentAdapter.ViewHolder>(DiffCallBack) {
    class ViewHolder(private val binding: ContinentListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(continentData: ContinentData) {
            binding.property = continentData
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ContinentListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val continentData = getItem(position)
        holder.bind(continentData)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<ContinentData>() {
        override fun areItemsTheSame(oldItem: ContinentData, newItem: ContinentData): Boolean {
            return oldItem.continent == newItem.continent
        }

        override fun areContentsTheSame(oldItem: ContinentData, newItem: ContinentData): Boolean {
            return oldItem == newItem
        }

    }
}