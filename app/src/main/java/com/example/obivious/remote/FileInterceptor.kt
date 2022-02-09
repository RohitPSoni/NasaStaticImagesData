package com.example.obivious.remote

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class FileInterceptor(private val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = context.assets.open("nasadata.json")
        val size: Int = response.available()
        val buffer = ByteArray(size)
        response.read(buffer)
        response.close()
        val result = String(buffer)
        return Response.Builder()
            .message(result)
            .code(200)
            .request(chain.request())
            .body(result.toResponseBody("application/json".toMediaTypeOrNull()))
            .protocol(Protocol.HTTP_1_0)
            .build()
    }
}