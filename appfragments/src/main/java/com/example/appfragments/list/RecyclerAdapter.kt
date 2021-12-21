package com.example.appfragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfragments.R
import com.example.appfragments.model.City
import com.squareup.picasso.Picasso
import com.udea.traneapp.base.BaseViewHolder
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val cityList: List<City>,
    private val itemClickListener: (City) -> Unit
) : RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return CityViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CityViewHolder -> holder.bind(cityList[position], position)
            else -> IllegalArgumentException("ERROR IN RECYCLERADAPTER")
        }
    }

    override fun getItemCount(): Int = cityList.size

    inner class CityViewHolder(itemView: View) : BaseViewHolder<City>(itemView) {
        override fun bind(item: City, position: Int) {

            val btn: Button = itemView.findViewById<Button>(R.id.cityDetail)

            val cityName: TextView = itemView.findViewById(R.id.cityName)
            val countryName: TextView = itemView.findViewById(R.id.countryName)
            val cityRate: TextView = itemView.findViewById(R.id.cityRate)
            val img1: ImageView = itemView.findViewById(R.id.imgOne)
            val img2: ImageView = itemView.findViewById(R.id.imgTwo)
            val img3: ImageView = itemView.findViewById(R.id.imgThree)

            cityName.text = item.cityName
            countryName.text = item.countryName
            cityRate.text = item.cityRate

            Picasso.get().load(item.cityImages[0]).into(img1)
            Picasso.get().load(item.cityImages[1]).into(img2)
            Picasso.get().load(item.cityImages[2]).into(img3)

            btn.setOnClickListener {
                itemClickListener(cityList[position])
            }

        }
    }

}