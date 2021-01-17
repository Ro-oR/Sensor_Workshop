package com.example.workshopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.workshopapp.databinding.ActivityGPSBinding

class GPS : AppCompatActivity() {
    private lateinit var binding:ActivityGPSBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGPSBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnBack.setOnClickListener {startActivity( Intent(this,MainActivity::class.java)) }

    }
}