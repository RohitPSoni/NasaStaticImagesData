package com.example.obivious.di

import com.example.obivious.NasaApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun NasaApplication.startDi() {
    startKoin {
        androidContext(applicationContext)
        modules(
            networkModule,
            repoModule,
            mapperModule,
            viewModelModule
        )
    }
}