package uk.co.appsauce.mvpappsauce

import com.appsauce.mvpappsauce.remote.ApiService
import com.appsauce.mvpappsauce.remote.RemoteServiceProd
import com.appsauce.mvpappsauce.remote.model.TestResponse
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteServiceProdTest {

    private val initCoroutineResponse = TestResponse()
    private val apiService = mock<ApiService>()
    private val remoteService = RemoteServiceProd(apiService)

    @Before
    fun before() {
        runBlocking {
            whenever(apiService.initCoroutine()).thenReturn(initCoroutineResponse)
        }
    }

    @Test
    fun testInitCoroutine() {
        runBlocking {
            val response = remoteService.initCoroutine()
            assert(response == initCoroutineResponse)
        }
    }
}