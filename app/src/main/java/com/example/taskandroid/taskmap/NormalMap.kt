package com.example.taskandroid.taskmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class NormalMap : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_map)

        // Get a handle to the fragment and register the callback.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    // Get a handle to the GoogleMap object and display marker.
    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(28.7041, 77.1025))
                .title("Marker")
        )
        //googleMap.moveCamera(newLatLng(LatLng(28.7041, 77.1025)))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(28.7041, 77.1025),5f))
    }
}