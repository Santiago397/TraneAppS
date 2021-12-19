package com.udea.traneapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udea.traneapp.base.BaseViewHolder
import com.udea.traneapp.model.City
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val context: Context,
    private val cityList: List<City>,
    private val itemClickListener: OnCityClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCityClickListener {
        fun onButtonClick(
            cityName: String,
            countryName: String,
            cityDescription: String,
            cityImages: ArrayList<String>,
            cityRate: String
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return CityViewHolder(
            LayoutInflater.from(context).inflate(R.layout.city_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CityViewHolder -> holder.bind(cityList[position], position)
            else -> IllegalArgumentException("ERROR IN VIEWHOLDER")
        }
    }

    override fun getItemCount(): Int = cityList.size

    inner class CityViewHolder(itemView: View) : BaseViewHolder<City>(itemView) {
        override fun bind(item: City, position: Int) {

            var btn: Button = itemView.findViewById<Button>(R.id.cityDetail)

            var cityName: TextView = itemView.findViewById(R.id.cityName)
            var countryName: TextView = itemView.findViewById(R.id.countryName)
            var cityRate: TextView = itemView.findViewById(R.id.cityRate)
            var img1: ImageView = itemView.findViewById(R.id.imgOne)
            var img2: ImageView = itemView.findViewById(R.id.imgTwo)
            var img3: ImageView = itemView.findViewById(R.id.imgThree)

            cityName.text = item.cityName
            countryName.text = item.countryName
            cityRate.text = item.cityRate

            Picasso.get().load(item.cityImages[0]).into(img1)
            Picasso.get().load(item.cityImages[1]).into(img2)
            Picasso.get().load(item.cityImages[2]).into(img3)

            btn.setOnClickListener {
                itemClickListener.onButtonClick(
                    item.cityName,
                    item.countryName,
                    item.cityDescription,
                    item.cityImages,
                    item.cityRate
                )
            }

        }
    }

}