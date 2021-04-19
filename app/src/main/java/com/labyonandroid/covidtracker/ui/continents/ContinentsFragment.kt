package com.labyonandroid.covidtracker.ui.continents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.labyonandroid.covidtracker.databinding.FragmentContinentsBinding

class ContinentsFragment : Fragment() {

    private lateinit var continentsViewModel: ContinentsViewModel
    private lateinit var binding: FragmentContinentsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        continentsViewModel =
            ViewModelProvider(this).get(ContinentsViewModel::class.java)
        binding = FragmentContinentsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.continentsViewModel = continentsViewModel

        val adapter = ContinentAdapter()
        binding.continentsListItems.adapter = adapter

        setHasOptionsMenu(true)
        return binding.root
    }
}