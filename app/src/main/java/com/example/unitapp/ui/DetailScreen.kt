package com.example.unitapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitapp.R
import com.example.unitapp.databinding.ActivityDetailScreenBinding

class DetailScreen : AppCompatActivity() {

    lateinit var binding:ActivityDetailScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")

        binding.unitId.text = getString(R.string.property_id_s,id.toString())
    }
}