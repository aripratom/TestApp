package com.example.testapp.data.api

import com.example.testapp.data.base.BaseResponse
import com.example.testapp.data.model.UserData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface APIService {

    @FormUrlEncoded
    @POST("/api/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseBody>

    @GET("/api/users?page=2")
    fun getUser(): Call<BaseResponse<List<UserData>>>
}