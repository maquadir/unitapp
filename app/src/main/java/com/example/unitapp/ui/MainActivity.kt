package com.example.unitapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unitapp.controllers.FetchPropertyController
import com.example.unitapp.databinding.ActivityMainBinding
import com.example.unitapp.repository.PropertiesRepo
import com.example.unitapp.service.PropertiesService
import com.example.unitapp.viewmodel.PropertiesViewModel
import com.example.unitapp.viewmodel.PropertyViewModelFactory

class MainActivity : AppCompatActivity() {

    private val propertiesService = PropertiesService.instance
    private val propertiesRepo = PropertiesRepo(propertiesService)

    private val propertiesViewModel: PropertiesViewModel by viewModels {
        PropertyViewModelFactory(propertiesRepo)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listsRecyclerview.layoutManager = LinearLayoutManager(baseContext)

        propertiesViewModel.propertiesLiveData.observe(this) {
            binding.listsRecyclerview.adapter = PropertyListAdapter(it.data, this)
        }

        propertiesViewModel.loaderLiveData.observe(this) {
            binding.progressBar.isVisible = it
        }
    }
}