package com.example.appfragments.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class City(
    @SerializedName("countryName")
    val countryName: String,
    @SerializedName("cityName")
    val cityName: String,
    @SerializedName("cityRate")
    val cityRate: String,


    @SerializedName("alt")
    val alt: String,

    @SerializedName("lon")
    val lon: String,


    @SerializedName("cityDescription")
    val cityDescription: String,
    @SerializedName("cityImages")
    val cityImages: List<String>
) : Serializable