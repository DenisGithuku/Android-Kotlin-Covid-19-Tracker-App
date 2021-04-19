package com.labyonandroid.covidtracker.ui.continents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.labyonandroid.covidtracker.model.ContinentData
import com.labyonandroid.covidtracker.network.Covid19Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class ContinentDataApiStatus { LOADING, DONE, ERROR }
class ContinentsViewModel : ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _properties = MutableLiveData<List<ContinentData>>()
    val properties: LiveData<List<ContinentData>>
        get() = _properties

    private val _status = MutableLiveData<ContinentDataApiStatus>()
    val status: LiveData<ContinentDataApiStatus>
        get() = _status


    init {
        initializeContinentData()
    }

    private fun initializeContinentData() {
        coroutineScope.launch {
            val getDeferred = Covid19Api.retrofitService.getAllContinentsAsync()
            try {
                val listResult = getDeferred.await()
                if (listResult.isNotEmpty()) {
                    _status.value = ContinentDataApiStatus.LOADING
                    _properties.value = listResult
                    _status.value = ContinentDataApiStatus.DONE
                }
            } catch (t: Throwable) {
                _properties.value = ArrayList()
                _status.value = ContinentDataApiStatus.ERROR
            }
        }
    }
}