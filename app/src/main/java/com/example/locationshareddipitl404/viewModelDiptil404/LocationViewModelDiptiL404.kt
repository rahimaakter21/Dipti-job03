package com.example.locationshareddipitl404.viewModelDiptil404

import android.Manifest
import android.Manifest.*
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.tasks.OnCompleteListener


class LocationViewModelDiptiL404:ViewModel() {

    private var fusedLocationClient: FusedLocationProviderClient? = null

    fun getLastLocation(callback: (String) -> Unit) {
        fusedLocationClient?.lastLocation
            ?.addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful && it.result != null) {
                    val lastLocation = it.result
                    val latitude = lastLocation.latitude
                    val longitude = lastLocation.longitude
                    val location = "Lat: $latitude, Long: $longitude"
                    callback(location)
                } else {
                    // Handle failure or missing permissions
                    callback("Location not available")
                }
            })
    }

    fun initializeFusedLocationClient(client: FusedLocationProviderClient) {
        fusedLocationClient = client
    }

}