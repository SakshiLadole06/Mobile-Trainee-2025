package com.example.taskandroid.taskmap

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Geocoder
import android.location.Location
import android.os.Build
import com.google.android.gms.location.LocationServices
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.taskandroid.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException
import java.util.Locale

class MarkerMap : AppCompatActivity(), OnMapReadyCallback {

    private val PERMISSION_REQUEST_CODE = 101
    private lateinit var myCurrentLocation: FusedLocationProviderClient
    private var currentLocation: Location? = null
    private var addressText: String = "Unknown Location"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker_map)// Initialize location provider
        myCurrentLocation = LocationServices.getFusedLocationProviderClient(this)
        // Get current location
        getCurrentLocation()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        currentLocation?.let { location ->
            val latLng = LatLng(location.latitude, location.longitude)
            val markerOptions = MarkerOptions()
                .position(latLng)
                .title(addressText)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_custom_marker))

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
            googleMap.addMarker(markerOptions)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation()
            } else {
                Toast.makeText(this, "Permission denied! Cannot fetch location.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), PERMISSION_REQUEST_CODE)
            return
        }

        myCurrentLocation.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                currentLocation = location
                getAddressFromLocation(location.latitude, location.longitude)  // Fetch address here

                // Show coordinates in a toast
                Toast.makeText(this, "${location.latitude}, ${location.longitude}", Toast.LENGTH_LONG).show()

                val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
                mapFragment?.getMapAsync(this)
            }
            else {
                Toast.makeText(this, "Failed to retrieve location.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getAddressFromLocation(latitude: Double, longitude: Double) {
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
//            if (!addresses.isNullOrEmpty()) {
//                addressText = addresses[0].getAddressLine(0) ?: "Unknown Location"
//            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                geocoder.getFromLocation(latitude, longitude, 1) { addresses ->
                    if (!addresses.isNullOrEmpty()) {
                        addressText = addresses[0].getAddressLine(0) ?: "Unknown Location"
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}




