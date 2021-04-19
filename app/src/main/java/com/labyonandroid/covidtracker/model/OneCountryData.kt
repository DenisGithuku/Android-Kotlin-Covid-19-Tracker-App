package com.labyonandroid.covidtracker.model

import com.squareup.moshi.Json

data class OneCountryData (
    val OneCountryData: OneCountryInfo
        )

data class OneCountryInfo (
    @Json(name = "_id")
    val Id: String
        )