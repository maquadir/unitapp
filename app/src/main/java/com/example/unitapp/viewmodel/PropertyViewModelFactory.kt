package com.example.unitapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unitapp.controllers.FetchPropertyController
import com.example.unitapp.repository.PropertiesRepo


class PropertyViewModelFactory(private val propertiesRepo: PropertiesRepo) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PropertiesViewModel(propertiesRepo, AppDispatchers()) as T
    }
}