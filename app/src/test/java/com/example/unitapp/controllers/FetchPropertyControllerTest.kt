package com.example.unitapp.controllers

import com.example.unitapp.models.Properties
import com.example.unitapp.repository.PropertiesRepo

class FetchPropertyControllerTest(private val propertiesRepo: PropertiesRepo) :
    IPropertyInterface {

    var propertyFetched = false

    override fun getProperty(callback: (Boolean, Properties?) -> Unit) {
        if (propertyFetched) {
            callback(true, Properties(emptyList()))
        } else {
            callback(false, null)
        }
    }
}