package com.udea.traneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udea.traneapp.Utils.Utils
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var countryNames: ArrayList<String> = ArrayList()
    var cityNames: ArrayList<String> = ArrayList()
    var cityContact: ArrayList<String> = ArrayList()
    var cityDescrip: ArrayList<String> = ArrayList()
    var cityUrlImg: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)

        recyclerView.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(Utils(this).getJsonObject(applicationContext))
            val citiesArray = obj.getJSONArray("cities")

            for (i in 0 until citiesArray.length()) {
                val cityData = citiesArray.getJSONObject(i)

                countryNames.add(cityData.getString("country"))
                cityNames.add(cityData.getString("pCity"))
                //usar JSONObject a ver si cambia los valores de los slashes
                cityUrlImg.add(cityData.getJSONArray("urlImg").toString())
            }

        } catch (ex: JSONException) {
            return ex.printStackTrace()
        }

        val cityAdapter = CityAdapter(
            this,
            countryNames,
            cityNames,
            cityUrlImg
        )

        recyclerView.adapter = cityAdapter


    }


}