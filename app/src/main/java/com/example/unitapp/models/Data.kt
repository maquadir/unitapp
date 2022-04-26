package com.example.unitapp.models

data class Data(
    val agent: Agent,
    val auction_date: String,
    val available_from: String,
    val bathrooms: Int,
    val bedrooms: Int,
    val carspaces: Int,
    val currency: String,
    val date_first_listed: String,
    val date_updated: String,
    val description: String,
    val display_price: String,
    val id: String,
    val location: Location,
    val owner: Owner,
    val property_images: List<PropertyImage>,
    val property_type: String,
    val sale_type: String
)