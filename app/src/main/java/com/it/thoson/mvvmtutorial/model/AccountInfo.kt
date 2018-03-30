package com.it.thoson.mvvmtutorial.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccountInfo {
    @SerializedName("user_name")
    @Expose
    var userName: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null
    @SerializedName("refresh_token")
    @Expose
    var refreshToken: String? = null

}