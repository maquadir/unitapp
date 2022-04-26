package com.example.unitapp.service

import android.util.Log
import com.example.unitapp.models.Properties
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PropertiesService {

    @GET("/properties")
    suspend fun getProperties(): Response<Properties>

    companion object {

        val instance: PropertiesService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://f213b61d-6411-4018-a178-53863ed9f8ec.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(PropertiesService::class.java)
        }
    }

}