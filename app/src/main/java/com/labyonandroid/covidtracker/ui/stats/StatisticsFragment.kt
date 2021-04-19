package com.labyonandroid.covidtracker.ui.stats

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.labyonandroid.covidtracker.R
import com.labyonandroid.covidtracker.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment() {
    private lateinit var binding: FragmentStatisticsBinding
    private lateinit var statsViewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStatisticsBinding.inflate(inflater)
        statsViewModel = ViewModelProvider(this).get(StatsViewModel::class.java)
        binding.lifecycleOwner = this
        binding.statsViewModel = statsViewModel

        return binding.root
    }
}