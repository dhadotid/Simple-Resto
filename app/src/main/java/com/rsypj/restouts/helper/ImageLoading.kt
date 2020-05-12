package com.rsypj.restouts.helper

import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

/**
 * Created by dhadotid on 21:34 | 2020-05-12.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

fun ImageView.loadCenterCropImage(url: String?, @DrawableRes placeholder: Int? = null) {
    loadCenterCropImage(if (url == null) null else Uri.parse(url), placeholder)
}

fun ImageView.loadImage(url: String?, @DrawableRes placeholder: Int? = null) {
    loadImage(if (url == null) null else Uri.parse(url), placeholder)
}

fun ImageView.loadImage(uri: Uri?, @DrawableRes placeholder: Int?) {
    Glide.with(this.context)
        .load(uri)
        .apply { if (placeholder != null) placeholder(placeholder) }
        .into(this)
}

fun ImageView.loadCenterCropImage(uri: Uri?, @DrawableRes placeholder: Int?) {
    Glide.with(this.context)
        .load(uri)
        .apply { if (placeholder != null) placeholder(placeholder) }
        .transform(CenterCrop())
        .into(this)
}

fun ImageView.loadRoundCornerCenterCropImage(uri: Uri?, radius: Int, @DrawableRes placeholder: Int?) {
    Glide.with(this.context)
        .load(uri)
        .apply { if (placeholder != null) placeholder(placeholder) }
        .transform(
            MultiTransformation<Bitmap>(
                CenterCrop(),
                RoundedCorners(radius)
            )
        )
        .into(this)
}

fun ImageView.loadRoundCornerCenterCropImage(url: String?, radius: Int, @DrawableRes placeholder: Int? = null) {
    loadRoundCornerCenterCropImage(if (url == null) null else Uri.parse(url), radius, placeholder)
}