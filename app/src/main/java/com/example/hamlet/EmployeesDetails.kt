package com.example.hamlet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hamlet.adapters.EmployeeViewPagerAdapter
import com.example.hamlet.fragments.employeefragment.EmploymentInfoFragment
import com.example.hamlet.fragments.employeefragment.PersonalInfoFragment
import kotlinx.android.synthetic.main.activity_employees_details.*

//
//lateinit var binding: ActivityEmployeesDetailsBinding

class EmployeesDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees_details)


        employees_name.text = getIntent().getStringExtra("EMPLOYEENAME")
        employees_role.text = getIntent().getStringExtra("EMPLOYEEROLE")
        employees_picture.setImageResource(getIntent().getStringExtra("EMPLOYEEIMAGE")!!.toInt())


        setupTabs()

    }

    private fun setupTabs() {
        val adapter = EmployeeViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PersonalInfoFragment(), "Personal Info")
        adapter.addFragment(EmploymentInfoFragment(), "Employment Info")

        viewPager.adapter = adapter
        tab1.setupWithViewPager(viewPager)

    }
}