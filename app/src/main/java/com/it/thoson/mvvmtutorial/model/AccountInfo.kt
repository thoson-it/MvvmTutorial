package com.it.thoson.mvvmtutorial.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccountInfo {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("is_friend")
    @Expose
    var isFriend: Boolean? = null
    @SerializedName("user_name")
    @Expose
    var userName: String? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null

}