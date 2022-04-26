package com.example.unitapp.controllers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitapp.models.Properties
import com.example.unitapp.repository.PropertiesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

interface IPropertyInterface {
    fun getProperty(callback: (Boolean, Properties?) -> Unit)
}

class FetchPropertyController(private val propertiesRepo: PropertiesRepo) :
    IPropertyInterface, ViewModel() {

    override fun getProperty(callback: (Boolean, Properties?) -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val properties = withContext(Dispatchers.IO) {
                    propertiesRepo.getProperties()
                }
                callback(true, properties.body())
            } catch (e: Exception) {
                //show error
                callback(false, null)
            }
        }
    }
}