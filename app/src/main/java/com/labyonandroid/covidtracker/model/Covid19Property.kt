package com.labyonandroid.covidtracker.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Covid19Property(
        val updated: String,
        val cases: String,
        val todayCases: String,
        val deaths: String,
        val todayDeaths: String,
        val recovered: String,
        val active: String,
        val critical: String
): Parcelable


