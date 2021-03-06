package com.example.hamlet.api

import com.example.hamlet.model.EmployeeResponse
import com.example.hamlet.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {
    @FormUrlEncoded
    @POST("auth/login")
    fun loginUser(@Field("email") email:String,
                  @Field("password") password: String): Call<LoginResponse>

    @GET("auth/admin")
    fun getAllEmployees(@Header("Authorization") token: String) : Call<EmployeeResponse>





}