package com.example.appfragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var listViewModel: ListViewModel
    private lateinit var recyclerAdapter: RecyclerAdapter
    private var cityList: ArrayList<City> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.getInfoJson(context?.assets?.open("cities.json"))

        listViewModel.onCityListLoaded.observe(viewLifecycleOwner, { result ->
            onCityLoadedSuscribe(result)
        })

        recyclerAdapter = RecyclerAdapter(cityList, itemClickListener = { this.onCityClicked(it)})

        listBinding.recyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerAdapter
        }
    }

    private fun onCityLoadedSuscribe(result: List<City>?) {
        result?.let { cityList ->
            recyclerAdapter.appendItems(cityList)

        }
    }

    private fun onCityClicked(city: City){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(city = city))
    }


}