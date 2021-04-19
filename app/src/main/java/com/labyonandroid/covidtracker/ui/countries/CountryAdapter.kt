package com.labyonandroid.covidtracker.ui.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.labyonandroid.covidtracker.databinding.CountryListBinding
import com.labyonandroid.covidtracker.model.AllCountryData

class CountryAdapter : ListAdapter<AllCountryData, CountryAdapter.ViewHolder>(DiffCallBack) {
    class ViewHolder(private val binding: CountryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(allCountryData: AllCountryData) {
            binding.property = allCountryData
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CountryListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val allCountryData = getItem(position)
        holder.bind(allCountryData)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<AllCountryData>() {
        override fun areItemsTheSame(oldItem: AllCountryData, newItem: AllCountryData): Boolean {
            return oldItem.country == newItem.country
        }

        override fun areContentsTheSame(
            oldItem: AllCountryData,
            newItem: AllCountryData
        ): Boolean {
            return oldItem == newItem
        }


    }
}