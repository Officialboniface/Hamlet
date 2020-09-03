package com.example.hamlet.model

import com.google.gson.annotations.SerializedName

data class Employees(
    @SerializedName("first_name")
    var employee_name: String,
    var job_title: String,
    @SerializedName("profile_pic")
    var employee_image: Int

)


data class EmployeesDetail(
    var dob: String,
    var city: String,
    var address: String,
    var qualification: String,
    var employee_gender: String,
    var employee_department: String,
    var phone: String,
    var email: String,
    var employee_id: String,
    var id: String,
    var job_category: String,
    var work_location:String,
    var employment_classification: String,
    var department: String,
    var description: String,
    var date_hired: String,
    var salary : String,
    var emergency_contact: String,
    var employee_salary: String
)
