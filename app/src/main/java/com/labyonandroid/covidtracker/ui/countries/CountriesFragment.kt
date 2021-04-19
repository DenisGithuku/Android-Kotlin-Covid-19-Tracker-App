package com.labyonandroid.covidtracker.ui.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.labyonandroid.covidtracker.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {
   private lateinit var binding: FragmentCountriesBinding
   private lateinit var countriesViewModel: CountriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCountriesBinding.inflate(inflater)
        countriesViewModel = ViewModelProvider(this).get(CountriesViewModel::class.java)
        binding.lifecycleOwner = this


        binding.countriesViewModel = countriesViewModel
        val adapter = CountryAdapter()
        binding.listItem.adapter = adapter


        return binding.root
    }

}