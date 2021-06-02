package com.example.testapp.data.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseResponse<T> {
    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("code")
    @Expose
    var code: Int? = null

    @SerializedName("data")
    @Expose
    var data: T? = null

    @SerializedName("error")
    @Expose
    var error: String? = null

    @SerializedName("token")
    @Expose
    var token: String? = null
}