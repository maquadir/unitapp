package com.example.unitapp.viewmodel

import com.example.unitapp.controllers.FetchPropertyControllerTest
import com.example.unitapp.models.Properties
import com.example.unitapp.repository.PropertiesRepo
import com.example.unitapp.service.PropertiesService
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class PropertiesViewModelTest : TestCase() {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var propertyController: FetchPropertyControllerTest

    private lateinit var propertyViewModel: PropertiesViewModel

    private var propertiesRepo = mock<PropertiesRepo>()

    private var propertiesService = mock<PropertiesService>()

    private val properties = mock<Properties>()

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = AppDispatchers(
        IO = StandardTestDispatcher(),
        MAIN = Dispatchers.Unconfined
    )

    //1
    @Before
    fun setup() {
        propertiesService = mock()
        propertiesRepo = PropertiesRepo(propertiesService)
        propertyViewModel = PropertiesViewModel(propertiesRepo, testDispatcher)
    }

    @Test
    fun `Fetching state works`() = runBlocking {
        whenever(propertiesRepo.getProperties().body()).thenReturn(properties)
        propertyViewModel = PropertiesViewModel(propertiesRepo, testDispatcher)
        Assert.assertEquals(false, propertyViewModel.loaderLiveData.value)
        Assert.assertEquals(properties, propertyViewModel.propertiesLiveData.value)
    }
}

