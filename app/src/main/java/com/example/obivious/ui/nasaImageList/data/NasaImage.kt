package com.example.obivious.ui.nasaImageList.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NasaImage(
    val title: String,
    val imageUrl: String?,
    val date: String?,
    val explanation: String?,
    val hdUrl: String?,
    val copyright: String?
): Parcelable