package com.example.hamlet.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") var token: String,
    @SerializedName("token_type") var token_type: String,
    @SerializedName("expires_in") var expires_in: Int,
    @SerializedName("user") var user: User
)


data class Employee(
    val id: Int,
    val job_details: JobDetails,
    val contact_info: ContactInfo
)
data class JobDetails(val id: Int)
data class ContactInfo(val id: Int)

data class EmployeeResponse(val employee: List<Employee>)



data class User(
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String
)