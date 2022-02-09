package com.example.obivious.repo

import com.example.obivious.mapper.NasaDataToImage
import com.example.obivious.remote.NasaApi
import com.example.obivious.remote.NetworkCall
import com.example.obivious.remote.ResultWrapper

interface ShowListRepository {
    suspend fun getAllList(): NasaInfo
}

class ShowListRepositoryImpl(
    private val nasaApi: NasaApi,
    private val mapper: NasaDataToImage,
    private val networkCall: NetworkCall
) : ShowListRepository {
    override suspend fun getAllList(): NasaInfo {
        return when(val info = networkCall.apiCall { nasaApi.getAllList() }) {
            is ResultWrapper.Success -> NasaInfo.NasaInformation(mapper.invoke(info.value))
            is ResultWrapper.Error -> NasaInfo.Error(info.error)
        }
    }
}