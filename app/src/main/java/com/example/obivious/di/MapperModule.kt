package com.example.obivious.di

import com.example.obivious.mapper.NasaDataToImage
import com.example.obivious.mapper.NasaDataToImageImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val mapperModule = module {
    single { NasaDataToImageImpl() } bind NasaDataToImage::class
}