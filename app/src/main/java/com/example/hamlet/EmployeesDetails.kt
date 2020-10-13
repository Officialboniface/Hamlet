package com.example.hamlet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hamlet.adapters.EmployeeViewPagerAdapter
import com.example.hamlet.fragments.employeefragment.EmploymentInfoFragment
import com.example.hamlet.fragments.employeefragment.PersonalInfoFragment
import com.example.hamlet.model.EmployeeResponse
import kotlinx.android.synthetic.main.activity_employees_details.*


class EmployeesDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees_details)
        setupTabs()
        val employeeDetails =
            intent.getParcelableExtra<EmployeeResponse.User.Employee>("employeeDetails")
        Log.e("TA", "employee details  $employeeDetails")
        val employeePicture = findViewById<ImageView>(R.id.employees_picture)
        val employeeJobTitle = findViewById<TextView>(R.id.employees_role)
        val employeeFirstName = findViewById<TextView>(R.id.firstName)
        val dateHired = findViewById<TextView>(R.id.date_hired)
        val salary = findViewById<TextView>(R.id.salary)
        val employmentType = findViewById<TextView>(R.id.employment_type)
        val employeeOtherName = findViewById<TextView>(R.id.otherNames)
        employeeFirstName.text = employeeDetails?.firstName
        employeeOtherName.text = employeeDetails?.otherNames
        employeeJobTitle.text = employeeDetails?.jobDetails?.jobTitle
        dateHired.text = employeeDetails?.jobDetails?.dateHired
        salary.text = employeeDetails?.jobDetails?.salary.toString()
        employmentType.text = employeeDetails?.jobDetails?.employmentType

        Glide.with(this)
            .load(employeeDetails?.profilePic)
            .circleCrop()
            .into(employeePicture)






        arrow_back.setOnClickListener {

            finish()
        }


    }

    private fun setupTabs() {
        val adapter = EmployeeViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PersonalInfoFragment(), "Personal Info")
        adapter.addFragment(EmploymentInfoFragment(), "Employment Info")

        viewPager.adapter = adapter
        tab1.setupWithViewPager(viewPager)

    }
}