package com.example.obivious.mapper

import com.example.obivious.remote.model.NasaData
import com.example.obivious.ui.nasaImageList.data.NasaImage

interface NasaDataToImage: Function1<List<NasaData>, List<NasaImage>>

class NasaDataToImageImpl: NasaDataToImage {
    override fun invoke(p1: List<NasaData>): List<NasaImage> {
        val nasaImageList = mutableListOf<NasaImage>()
        p1.forEach {
            val nasaImage = NasaImage(
                title = it.title,
                imageUrl = it.url,
                date = it.date,
                explanation = it.explanation,
                hdUrl = it.hdurl,
                copyright = it.copyright
            )
            nasaImageList.add(nasaImage)
        }
        return nasaImageList
    }
}