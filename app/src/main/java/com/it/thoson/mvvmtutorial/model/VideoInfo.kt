package com.it.thoson.mvvmtutorial.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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

}