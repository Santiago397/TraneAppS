package com.example.appfragments.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.appfragments.R
import com.example.appfragments.detail.DetailFragmentArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val args: MapsFragmentArgs by navArgs()




    private val callback = OnMapReadyCallback { googleMap ->

        val a = args.city
        val b = args.city
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val sydney = LatLng(args.city.alt.toDouble(), args.city.lon.toDouble())
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        googleMap

        val bogota = LatLng(args.city.alt.toDouble(), args.city.lon.toDouble())
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Bogota"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota, 15F))

        val medellin = LatLng(args.city.alt.toDouble(), args.city.lon.toDouble())
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Medellin"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 15F))

        val cartagena = LatLng(args.city.alt.toDouble(), args.city.lon.toDouble())
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Cartagena"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cartagena, 15F))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}