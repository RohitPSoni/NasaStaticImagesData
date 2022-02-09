package com.example.obivious.remote

import com.example.obivious.mock
import com.example.obivious.remote.model.NasaData
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import retrofit2.Response
import java.lang.Exception

class NetworkCallTest {
    private val networkCall: NetworkCall = NetworkCallImpl()
    private val api: NasaApi = mock()

    @Test
    fun `when call has exception`() = runBlocking {
        Mockito.`when`(api.getAllList()).thenAnswer {
            throw Exception("Some error")
        }
        val response = networkCall.apiCall { api.getAllList() }
        Assertions.assertTrue((response as ResultWrapper.Error).error?.localizedMessage == "Some error")
    }

    @Test
    fun `when response is not successFull`() = runBlocking{
        val responseBody = "Failed to call".toResponseBody("application/json".toMediaTypeOrNull())
        val mockResponse = Response.error<List<NasaData>>(400, responseBody)
        Mockito.`when`(api.getAllList()).thenReturn(mockResponse)
        val response = networkCall.apiCall { api.getAllList() }
        Assertions.assertTrue((response is ResultWrapper.Error))
    }

    @Test
    fun `when response is successFull but empty body`() = runBlocking{
        val mockResponse = Response.success(generateMockNetworkList())
        Mockito.`when`(api.getAllList()).thenReturn(mockResponse)
        val response = networkCall.apiCall { api.getAllList() }
        Assertions.assertTrue((response is ResultWrapper.Success))
    }

    private fun generateMockNetworkList(): List<NasaData> {
        val list = mutableListOf<NasaData>()
        list.add(
            NasaData(null, null, null, null, null, null, "Title1", null)
        )
        list.add(NasaData(null, null, null, null, null, null, "Title2", "Some URL"))
        return list
    }
}