package com.example.hamlet.model

import com.google.gson.annotations.SerializedName

data class EmployeesList(
    @SerializedName("id")
    var id: Int,
    @SerializedName("username")
    var username: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("employees")
    var employees: Employees
)

data class Employees(
    @SerializedName("id")
    var id: Int,
    @SerializedName("user_id")
    var user_id: Int,
    @SerializedName("company_id")
    var company_id: Int,
    @SerializedName("first_name")
    var first_name: String,
    @SerializedName("id")
    var other_names: String,
    var gender: String,
    @SerializedName("id")
    var profile_pic: Int,
    var dob: Int,
    @SerializedName("id")
    var address: String,
    var city: String,
    @SerializedName("id")
    var qualification: String,
    @SerializedName("id")
    var job_details: Job_details
)

data class Job_details(
    @SerializedName("id")
    var id: Int,
    @SerializedName("employee_id")
    var employee_id: Int,
    @SerializedName("employment_type")
    var employment_type: String,
    @SerializedName("job_title")
    var job_title: String,
    @SerializedName("salary")
    var salary: Int,
    @SerializedName("date_hired")
    var date_hired: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("department")
    var department: String,
    @SerializedName("employment_classification")
    var employment_classification: String,
    @SerializedName("job_category")
    var job_category: String,
    @SerializedName("work_location")
    var work_location: String,
    @SerializedName("contact_info")
    var contact_info: Contact_info
)

data class Contact_info(
    @SerializedName("id")
    var id: Int,
    @SerializedName("employee_id")
    var employee_id: Int,
    @SerializedName("phone")
    var phone: Int,
    @SerializedName("email")
    var email: String,
    @SerializedName("emergency_contact")
    var emergency_contact: String
)


