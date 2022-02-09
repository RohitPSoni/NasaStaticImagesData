package com.example.obivious.binders

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.obivious.ext.load

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?){
    imageView.load(url)
}