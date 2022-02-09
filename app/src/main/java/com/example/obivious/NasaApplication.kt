package com.example.obivious

import android.app.Application
import com.example.obivious.di.startDi

class NasaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startDi()
    }
}