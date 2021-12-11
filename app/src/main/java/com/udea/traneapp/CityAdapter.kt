package com.udea.traneapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CityAdapter(
    private var context: Context,
    private var countryNames: ArrayList<String>,
    private var cityNames: ArrayList<String>,
    private var cityUrl: ArrayList<String>
) :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return CityViewHolder(view)

    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Si no funciona, deben poner <View>
        var country: TextView = itemView.findViewById<TextView>(R.id.country)
        var pCity: TextView = itemView.findViewById<TextView>(R.id.pCity)
        var img1: ImageView = itemView.findViewById<ImageView>(R.id.imgOne)
        var img2: ImageView = itemView.findViewById<ImageView>(R.id.imgTwo)
        var img3: ImageView = itemView.findViewById<ImageView>(R.id.imgThree)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.country.text = countryNames[position]
        holder.pCity.text = cityNames[position]

        val nameImg1 =
            "https://images.unsplash.com/photo-1568632234180-0e6c08735d01?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
        val nameImg2 =
            "https://images.unsplash.com/photo-1568632234168-5d77a6ff2396?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
        val nameImg3 =
            "https://images.unsplash.com/photo-1568632234166-53e491e85b3d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"

        Picasso.get().load(nameImg1).into(holder.img1)
        Picasso.get().load(nameImg2).into(holder.img2)
        Picasso.get().load(nameImg3).into(holder.img3)


    }


    override fun getItemCount(): Int {
        return cityNames.size
    }

}