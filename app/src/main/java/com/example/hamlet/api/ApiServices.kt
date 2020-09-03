package com.example.hamlet.api


import com.example.hamlet.model.Employees
import com.example.hamlet.model.EmployeesList
import com.example.hamlet.model.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.*

interface ApiServices {
    @FormUrlEncoded
    @POST("auth/login")
    fun loginUser(@Field("email") email:String,
                  @Field("password") password: String): Call<LoginResponse>

    @FormUrlEncoded
    @Headers ("Authorization : bearer")
    @GET("api/employee")
    fun getAllEmployees() : Call<List<Employees>>







}