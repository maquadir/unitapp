package com.example.unitapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unitapp.controllers.IPropertyInterface
import com.example.unitapp.models.Properties
import com.example.unitapp.repository.PropertiesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class PropertiesViewModel(private val propertiesRepo: PropertiesRepo,
                          private val appDispatchers: AppDispatchers) : ViewModel() {

    private val propertiesMutableLiveData = MutableLiveData<Properties>()
    val propertiesLiveData: LiveData<Properties>
        get() = propertiesMutableLiveData
    private val mutableLoader = MutableLiveData(true)
    val loaderLiveData: LiveData<Boolean>
        get() = mutableLoader

    init {
        getProperties()
    }

    fun getProperties() {
        viewModelScope.launch {
            try {
                val properties = withContext(appDispatchers.IO) {
                    propertiesRepo.getProperties()
                }
                propertiesMutableLiveData.value = properties.body()
                mutableLoader.value = false
            } catch (e: Exception) {
                propertiesMutableLiveData.value = null
                mutableLoader.value = false
            }
        }
//        iPropertyInterface.getProperty { isFetched, properties ->
//            if (isFetched) {
//        propertiesMutableLiveData.value = properties
//        mutableLoader.value = false
//            } else {
//                //show error
//                propertiesMutableLiveData.value = null
//                mutableLoader.value = false
//            }
//        }
    }
}