package com.example.hamlet.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class EmployeeResponse(
    val user: User
) {
    data class User(
        val id: Int,
        val username: String,
        val email: String,
        @SerializedName("email_verified_at")
        val emailVerifiedAt: Any,
        @SerializedName("created_at")
        val createdAt: Any,
        @SerializedName("updated_at")
        val updatedAt: Any,
        val company: Company,
        val profile: Profile,
        val employees: List<Employee>
    ) {
        data class Company(
            val id: Int,
            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("company_name")
            val companyName: String,
            @SerializedName("company_email")
            val companyEmail: String,
            @SerializedName("company_address")
            val companyAddress: String,
            val city: String,
            val state: String,
            @SerializedName("zip_code")
            val zipCode: String,
            @SerializedName("company_phone")
            val companyPhone: String,
            @SerializedName("company_website")
            val companyWebsite: String,
            @SerializedName("no_of_employees")
            val noOfEmployees: String,
            @SerializedName("company_logo")
            val companyLogo: String,
            val services: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("company_departments")
            val companyDepartments: List<CompanyDepartment>
        ) {
            data class CompanyDepartment(
                val id: Int,
                val name: String,
                @SerializedName("company_id")
                val companyId: Int,
                @SerializedName("created_at")
                val createdAt: Any,
                @SerializedName("updated_at")
                val updatedAt: Any
            )
        }

        data class Profile(
            val id: Int,
            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("first_name")
            val firstName: String,
            @SerializedName("last_name")
            val lastName: String,
            val address: String,
            @SerializedName("profile_pic")
            val profilePic: String
        )

        @Parcelize
        data class Employee(
            val id: Int,
            @SerializedName("user_id")
            val userId: Int,
            @SerializedName("company_id")
            val companyId: Int,
            @SerializedName("first_name")
            val firstName: String,
            @SerializedName("other_names")
            val otherNames: String,
            val gender: String,
            @SerializedName("profile_pic")
            val profilePic: String,
            val dob: String,
            val address: String,
            val city: String,
            val qualification: String,
            @SerializedName("job_details")
            val jobDetails: JobDetails,
            @SerializedName("contact_info")
            val contactInfo: JobDetails.ContactInfo
        ) :
            Parcelable {
            @Parcelize
            data class JobDetails(
                val id: Int,
                @SerializedName("employee_id")
                val employeeId: Int,
                @SerializedName("employment_type")
                val employmentType: String,
                @SerializedName("job_title")
                val jobTitle: String,
                val salary: Int,
                @SerializedName("date_hired")
                val dateHired: String,
                val description: String,
                val department: String,
                @SerializedName("employment_classification")
                val employmentClassification: String,
                @SerializedName("job_category")
                val jobCategory: String,
                @SerializedName("work_location")
                val workLocation: String

            ) :

                Parcelable {

                @Parcelize
                data class ContactInfo(
                    val id: Int,
                    @SerializedName("employee_id")
                    val employeeId: Int,
                    val phone: String,
                    val email: String,
                    @SerializedName("emergency_contact")
                    val emergencyContact: String

                ) : Parcelable
            }
        }
    }
}