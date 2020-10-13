package com.example.hamlet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.hamlet.MainActivity
import com.example.hamlet.R
import com.example.hamlet.adapters.EmployeeViewPagerAdapter
import com.example.hamlet.adapters.ProfileViewPagerAdapter
import com.example.hamlet.fragments.companyfragment.CompanyDetailsFragment
import com.example.hamlet.fragments.companyfragment.ManagerDetailsFragment
import com.example.hamlet.fragments.employeefragment.EmploymentInfoFragment
import com.example.hamlet.fragments.employeefragment.PersonalInfoFragment
import com.example.hamlet.model.EmployeeResponse
import kotlinx.android.synthetic.main.activity_employees_details.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupTabs()


        arrowBtn.setOnClickListener {
            finish()
        }
    }



    private fun setupTabs() {
        val adapter = ProfileViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ManagerDetailsFragment(), "Manager Profile")
        adapter.addFragment(CompanyDetailsFragment(), "Company Details")
        profile_viewPager.adapter = adapter
        profile_tab.setupWithViewPager(profile_viewPager)

    }



}