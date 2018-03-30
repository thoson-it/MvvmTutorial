package com.it.thoson.mvvmtutorial.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import android.databinding.BindingAdapter
import android.widget.ImageView


class VideoInfo {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("thumb")
    @Expose
    var thumb: String? = null
    @SerializedName("url_download")
    @Expose
    var urlDownload: String? = null
    @SerializedName("url_play")
    @Expose
    var urlPlay: String? = null
    @SerializedName("from_user")
    @Expose
    var fromUser: AccountInfo? = null
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @SerializedName("last_comment")
    @Expose
    var lastComment: String? = null
//
//    @BindingAdapter("bind:imageUrl")
//    fun loadImage(view: ImageView, thumb : String) {
//        Picasso.with(view.context)
//                .load(thumb)
//                .into(view)
//    }

    fun getImageUrl(): String {
        // The URL will usually come from a model (i.e Profile)
        return "http://cdn.meme.am/instances/60677654.jpg"
    }

    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String) {
        Picasso.with(view.context)
                .load("http://cdn.meme.am/instances/60677654.jpg")
                .into(view)
    }
}