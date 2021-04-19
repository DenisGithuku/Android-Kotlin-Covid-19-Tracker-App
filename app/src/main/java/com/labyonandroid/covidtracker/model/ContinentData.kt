package com.labyonandroid.covidtracker.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContinentData (
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