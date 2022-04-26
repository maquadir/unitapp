package com.example.unitapp.viewmodel

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

data class AppDispatchers(
    val IO: CoroutineDispatcher = Dispatchers.IO,
    val MAIN: CoroutineDispatcher = Dispatchers.Main
)