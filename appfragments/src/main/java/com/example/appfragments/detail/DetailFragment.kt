package com.example.appfragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.appfragments.databinding.FragmentDetailBinding
import com.example.appfragments.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city = args.city

        with(detailBinding){

            cityName2.text = city.cityName
            countryName2.text = city.countryName
            txtRate.text = city.cityRate
            cityDescrip.text = city.cityDescription

            btnMap.setOnClickListener{
                 findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(city = city))
            }

            if (city.cityImages.size > 0) {
                Glide.with(requireContext()).load(city.cityImages[0]).into(imageDetail)
            }
        }

    }

}