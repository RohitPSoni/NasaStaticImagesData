package com.example.obivious.repo

import com.example.obivious.ui.nasaImageList.data.NasaImage

sealed class NasaInfo {
    data class NasaInformation(val nasaList: List<NasaImage>): NasaInfo()
    data class Error(val throwable: Throwable?): NasaInfo()
}