package com.example.hamlet.api

import android.provider.ContactsContract
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiCalls {
@POST("/api/auth/login")
@FormUrlEncoded
fun loginUser (@Field("email")email: String,
               @Field("password")password: String):
        Call<LoginResponse>
    data class LoginResponse (
        val token: String,
        val token_type: String
    )
}