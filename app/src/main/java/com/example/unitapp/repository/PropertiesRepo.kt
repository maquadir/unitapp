package com.example.unitapp.repository

import com.example.unitapp.service.PropertiesService

class PropertiesRepo(private val propertiesService: PropertiesService) {

    suspend fun getProperties() = propertiesService.getProperties()
}