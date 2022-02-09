package com.example.obivious.di

import com.example.obivious.BuildConfig
import com.example.obivious.remote.FileInterceptor
import com.example.obivious.remote.NasaApi
import com.example.obivious.remote.NetworkCall
import com.example.obivious.remote.NetworkCallImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { NetworkCallImpl() } bind NetworkCall::class
    single { FileInterceptor(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideExchangeApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideOkHttpClient(interceptor: FileInterceptor): OkHttpClient {
    val client = OkHttpClient().newBuilder()
    if (BuildConfig.DEBUG) {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        client.addInterceptor(logger)
        client.addInterceptor(interceptor)
    }
    return client.build()
}

fun provideExchangeApi(retrofit: Retrofit): NasaApi = retrofit.create(NasaApi::class.java)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Builder().baseUrl("https://rickandmortyapi.com/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}