package com.labyonandroid.covidtracker.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.labyonandroid.covidtracker.R
import com.labyonandroid.covidtracker.model.AllCountryData
import com.labyonandroid.covidtracker.model.ContinentData
import com.labyonandroid.covidtracker.ui.continents.ContinentAdapter
import com.labyonandroid.covidtracker.ui.continents.ContinentDataApiStatus
import com.labyonandroid.covidtracker.ui.countries.CountriesApiStatus
import com.labyonandroid.covidtracker.ui.countries.CountryAdapter
import com.labyonandroid.covidtracker.ui.stats.Covid19ApiStatus

@BindingAdapter("imgSrc")
fun bindStatus(imageView: ImageView, status: CountriesApiStatus?) {
    when (status) {
        CountriesApiStatus.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }
        CountriesApiStatus.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_connection_error)
        }
        CountriesApiStatus.DONE -> {
            imageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("imgSrcContinents")
fun bindStatus(imageView: ImageView, status: ContinentDataApiStatus?) {
    when (status) {
        ContinentDataApiStatus.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }
        ContinentDataApiStatus.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_connection_error)
        }
        ContinentDataApiStatus.DONE -> {
            imageView.visibility = View.GONE
        }
    }
}


@BindingAdapter("countryListData")
fun bindCountryListData(recyclerView: RecyclerView, data: List<AllCountryData>?) {
    val adapter = recyclerView.adapter as CountryAdapter
    adapter.submitList(data)
}

@BindingAdapter("continentListData")
fun bindContinentListData(recyclerView: RecyclerView, data: List<ContinentData>?) {
    val adapter = recyclerView.adapter as ContinentAdapter
    adapter.submitList(data)
}
