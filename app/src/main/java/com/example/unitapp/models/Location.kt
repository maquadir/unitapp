package com.example.unitapp.models

data class Location(
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val postcode: String,
    val state: String,
    val suburb: String
)