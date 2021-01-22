package com.example.workshop_solution

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.workshop_solution.databinding.ActivityGPSBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class GPS : AppCompatActivity() {
    private lateinit var binding: ActivityGPSBinding
    private lateinit var fusedLocationClient : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGPSBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnBack.setOnClickListener {startActivity( Intent(this,MainActivity::class.java)) }
        binding.locationBtn.setOnClickListener { checkingPermissons() }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    private fun checkingPermissons() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
                    updateLocation()
                }
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) -> {
                    showDialog()
                }
                else -> {
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), PackageManager.PERMISSION_GRANTED)
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun updateLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location : Location -> onLocationReceived(location) }
    }

    private fun onLocationReceived(location: Location?){
        val locationText = location?.latitude.toString() + "|" + location?.longitude.toString()
        binding.locationTxt.text = locationText
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Permission to access your GPS is required for this App")
            setTitle("Permission required")
            setPositiveButton("OK") { dialog, which ->
                ActivityCompat.requestPermissions(this@GPS, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), PackageManager.PERMISSION_GRANTED)
            }
        }
    }
}