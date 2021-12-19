package com.udea.traneapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class CityDetail : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        if (intent.extras != null) {
            val txtCity = findViewById<TextView>(R.id.cityName2)
            val txtCountry = findViewById<TextView>(R.id.countryName2)
            val txtDescription = findViewById<TextView>(R.id.cityDescrip)
            val txtRate = findViewById<TextView>(R.id.txtRate)
            val img = findViewById<ImageView>(R.id.imageDetail)

            val urlImg = intent.getStringArrayListExtra("cityImages")
            txtCity.text = intent.getStringExtra("cityName")
            txtCountry.text = intent.getStringExtra("countryName")
            txtDescription.text = intent.getStringExtra("cityDescription")
            txtRate.text = intent.getStringExtra("cityRate")
            if (urlImg != null) {
                Picasso.get().load(urlImg[0]).into(img)
            }
        }
    }
}