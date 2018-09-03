package com.cyclopsdev.commons

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String){
        Glide.with(imageView)
                .load(url)
                .into(imageView)
    }