package com.example.workshopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workshopapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        val cambutton = findViewById<Button>(R.id.btn_open_camera)
        cambutton.setOnClickListener() {
            val intent = Intent(this, Camera::class.java)
            startActivity(intent)
        }
        val gpsbutton = findViewById<Button>(R.id.btn_open_gps)
        gpsbutton.setOnClickListener() {
            val intent2 = Intent(this, GPS::class.java)
            startActivity(intent2)
        }


         */

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnOpenCamera.setOnClickListener() {startActivity(Intent(this,Fehler::class.java))}
        binding.btnOpenGps.setOnClickListener() {startActivity(Intent(this,GPS::class.java))}
    }


    }
