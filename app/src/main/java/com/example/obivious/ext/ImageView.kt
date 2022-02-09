package com.example.obivious.ext

import android.widget.ImageView
import com.example.obivious.R
import com.example.obivious.base.GlideApp

fun ImageView.load(url: String?) {
    GlideApp.with(context)
        .load(url)
        .override(600, 200) // resizes the image to these dimensions (in pixel). resize does not respect aspect ratio
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}