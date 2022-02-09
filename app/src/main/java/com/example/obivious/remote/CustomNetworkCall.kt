package com.example.obivious.remote

import retrofit2.Response
import java.lang.Exception

interface NetworkCall {
    suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): ResultWrapper<T>
}

class NetworkCallImpl : NetworkCall {
    override suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): ResultWrapper<T> {
        val response = runCatching {
            call.invoke()
        }.getOrElse {
            return ResultWrapper.Error(it)
        }
        return if (!response.isSuccessful) {
            ResultWrapper.Error(Exception(response.message()))
        } else {
            response.body()?.let {
                ResultWrapper.Success(it)
            } ?: run {
                ResultWrapper.Error(Exception("response.body() can't be null"))
            }
        }
    }
}