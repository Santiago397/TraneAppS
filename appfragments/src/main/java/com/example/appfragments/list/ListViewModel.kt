package com.example.appfragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfragments.model.City
import com.example.appfragments.model.CityList
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel: ViewModel() {

    private var cityListLoad: MutableLiveData<ArrayList<City>> = MutableLiveData()
    var onCityListLoaded: LiveData<ArrayList<City>> = cityListLoad

    fun getInfoJson(listString: InputStream?) {
        val cityListString = listString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        cityListLoad.value = gson.fromJson(cityListString, CityList::class.java)

    }

}