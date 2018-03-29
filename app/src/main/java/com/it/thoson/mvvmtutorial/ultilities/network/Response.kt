package com.it.thoson.mvvmtutorial.ultilities.network

import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("status")
    var status: String
    constructor(status: String) {
        this.status = status
    }
}
