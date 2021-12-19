package com.udea.traneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udea.traneapp.Utils.Utils
import com.udea.traneapp.model.City
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnCityClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Get the info from the json and put it in a List
        val cityList = getInfo()

        recyclerView.adapter = RecyclerAdapter(this, cityList, this)
    }

    private fun getInfo(): List<City> {

        val cityList = mutableListOf<City>()

        try {
            val obj = JSONObject(Utils(this).getJsonObject(applicationContext))
            val citiesArray = obj.getJSONArray("cities")

            for (i in 0 until citiesArray.length()) {
                val cityData = citiesArray.getJSONObject(i)

                var cityName = cityData.getString("pCity")
                var countryName = cityData.getString("country")
                var cityDescription = cityData.getString("description")
                var cityRate = cityData.getString("rate")
                var cityImages: ArrayList<String> = ArrayList()

                var imgArray = cityData.getJSONArray("urlImg")

                for (a in 0 until imgArray.length()) {
                    cityImages.add(imgArray.get(a).toString())
                }

                cityList.add(City(cityName, countryName, cityDescription, cityRate, cityImages))

            }

        } catch (ex: JSONException) {
            ex.printStackTrace()
        }

        return cityList
    }

    override fun onButtonClick(
        cityName: String,
        countryName: String,
        cityDescription: String,
        cityImages: ArrayList<String>,
        cityRate: String
    ) {
        val intent = Intent(this, CityDetail::class.java)
        intent.putExtra("cityName", cityName)
        intent.putExtra("countryName", countryName)
        intent.putExtra("cityDescription", cityDescription)
        intent.putStringArrayListExtra("cityImages", cityImages)
        intent.putExtra("cityRate", cityRate)
        startActivity(intent)
    }
}