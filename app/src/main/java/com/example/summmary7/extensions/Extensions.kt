package com.example.summmary7.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.summmary7.R

fun ImageView.setImage(url: String?) {
    if (url != null) {
        Glide.with(this.context).load(url).placeholder(R.mipmap.placeholder).into(this)
    } else {
        Glide.with(this.context).load(R.mipmap.placeholder).into(this)
    }
}

fun ImageView.setImage(resId: Int) {
    Glide.with(context).load(resId).placeholder(R.mipmap.placeholder).into(this)

}

fun View.hide() {
    visibility = View.GONE
}