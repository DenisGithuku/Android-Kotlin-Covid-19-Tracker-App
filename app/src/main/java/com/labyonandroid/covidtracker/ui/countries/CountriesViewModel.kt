package com.labyonandroid.covidtracker.ui.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.labyonandroid.covidtracker.model.AllCountryData
import com.labyonandroid.covidtracker.network.Covid19Api
import com.labyonandroid.covidtracker.ui.continents.ContinentDataApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class CountriesApiStatus { LOADING, DONE, ERROR }
class CountriesViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private val _properties = MutableLiveData<List<AllCountryData>>()
    val properties: LiveData<List<AllCountryData>>
        get() = _properties


    private val _status = MutableLiveData<CountriesApiStatus>()
    val status: LiveData<CountriesApiStatus>
        get() = _status

    init {
        getAllCountriesProperties()
    }

    private fun getAllCountriesProperties() {
        coroutineScope.launch {
            val getAllCountriesDeferred = Covid19Api.retrofitService.getAllCountriesAsync()
            try {
                val listResult = getAllCountriesDeferred.await()
                if (listResult.isNotEmpty()) {
                    _status.value = CountriesApiStatus.LOADING
                    _properties.value = listResult
                    _status.value = CountriesApiStatus.DONE

                }
            } catch (t: Throwable) {
                _status.value = CountriesApiStatus.ERROR

            }
        }
    }
}