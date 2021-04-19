package com.labyonandroid.covidtracker.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.labyonandroid.covidtracker.model.AllCountryData
import com.labyonandroid.covidtracker.model.ContinentData
import com.labyonandroid.covidtracker.model.Covid19Property
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://corona.lmao.ninja/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface Covid19ApiService {
    @GET("all")
    fun getSummaryAsync():
            Deferred<Covid19Property>

    @GET("countries?sort=country")
    fun getAllCountriesAsync():
            Deferred<List<AllCountryData>>

    @GET("continents")
    fun getAllContinentsAsync():
            Deferred<List<ContinentData>>
}

object Covid19Api {
    val retrofitService: Covid19ApiService by lazy {
        retrofit.create(Covid19ApiService::class.java)
    }
}