package com.labyonandroid.covidtracker.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllCountryData(
    val updated: String,
    val country: String,
    val cases: String,
    val todayCases: String,
    val deaths: String,
    val continent: String,
    val todayDeaths: String,
    val recovered: String,
    val todayRecovered: String,
    val active: String,
    val critical: String,
    val population: String
): Parcelable