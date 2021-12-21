package com.example.appfragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfragments.databinding.FragmentListBinding
import com.example.appfragments.main.MainActivity
import com.example.appfragments.model.City
import com.example.appfragments.model.CityList
import com.example.appfragments.utils.Utils
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var cityList: List<City>
    private lateinit var recyclerAdapter: RecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        cityList = getInfoJson()
        recyclerAdapter = RecyclerAdapter(cityList, itemClickListener = { this.onCityClicked(it)})
        listBinding.recyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }
    }

    private fun onCityClicked(city: City){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(city = city))
    }

    private fun getInfoJson(): List<City> {

        val cityList = mutableListOf<City>()

        try {
            val obj = JSONObject(Utils(requireContext()).getJsonObject(requireContext()))
            val citiesArray = obj.getJSONArray("cities")

            for (i in 0 until citiesArray.length()) {
                val cityData = citiesArray.getJSONObject(i)

                val cityName = cityData.getString("cityName")
                val countryName = cityData.getString("countryName")
                val cityDescription = cityData.getString("cityDescription")
                val cityRate = cityData.getString("cityRate")
                val cityImages: ArrayList<String> = ArrayList()

                val imgArray = cityData.getJSONArray("cityImages")

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
}