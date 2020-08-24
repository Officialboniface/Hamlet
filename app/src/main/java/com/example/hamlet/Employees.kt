package com.example.hamlet

data class Employees(
    var employee_name: String,
    var employee_role: String,
    var employee_image: Int

)


data class EmployeesDetail( var employee_dob: Int,
                            var employee_gender: String,
                            var employee_department: String,
                            var employee_salary: String)

