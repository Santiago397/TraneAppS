package com.example.appfragments.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class  City(
    @SerializedName("cityName")
    val cityName:String,
    @SerializedName("countryName")
    val countryName:String,
    @SerializedName("cityDescription")
    val cityDescription:String,
    @SerializedName("cityRate")
    val cityRate:String,
    @SerializedName("cityImages")
    val cityImages: ArrayList<String>
    ) : Serializable