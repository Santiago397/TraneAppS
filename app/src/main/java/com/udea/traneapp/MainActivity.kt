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

    var cityName: ArrayList<String> = ArrayList()
    var cityDepartment: ArrayList<String> = ArrayList()
    var cityDescription: ArrayList<String> = ArrayList()
    var cityTemp: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(applicationContext)

        recyclerView.layoutManager = linearLayoutManager
        try {
            val obj = JSONObject(Utils(this).loadJsonFromAssets(applicationContext, "cities.json"))
            val citiesArray = JSONArray("cities")

            for (i in 0 until citiesArray.length()) {
                val cityInfo = citiesArray.getJSONObject(i)
                cityName.add(cityInfo.getString("capital"))
                cityDepartment.add(cityInfo.getString("department"))
                cityDescription.add(cityInfo.getString("description"))
                cityTemp.add(cityInfo.getString("temperature"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }


    }
}