package com.labyonandroid.covidtracker.ui.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.labyonandroid.covidtracker.model.Covid19Property
import com.labyonandroid.covidtracker.network.Covid19Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class Covid19ApiStatus { LOADING, ERROR, DONE }
class StatsViewModel : ViewModel() {

    private val _properties = MutableLiveData<Covid19Property?>()
    val properties: LiveData<Covid19Property?>
        get() = _properties


    private val _status = MutableLiveData<Covid19ApiStatus>()
    val status: LiveData<Covid19ApiStatus>
        get() = _status

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        initializeCovid19Property()
    }


    private fun initializeCovid19Property() {
        uiScope.launch {
            val getDeferred = Covid19Api.retrofitService.getSummaryAsync()
            try {
                val listResult = getDeferred.await()
                _status.value = Covid19ApiStatus.LOADING
                _properties.value = listResult
                _status.value = Covid19ApiStatus.DONE
            } catch (t: Throwable) {
                _status.value = Covid19ApiStatus.ERROR
                _response.value = "Failure: ${t.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

