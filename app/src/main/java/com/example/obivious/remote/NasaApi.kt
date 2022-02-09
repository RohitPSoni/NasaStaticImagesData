package com.example.obivious.remote

import com.example.obivious.remote.model.NasaData
import retrofit2.Response
import retrofit2.http.GET

interface NasaApi {
    @GET("character/")
    suspend fun getAllList() : Response<List<NasaData>>
}