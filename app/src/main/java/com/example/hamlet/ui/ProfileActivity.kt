package com.example.hamlet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hamlet.MainActivity
import com.example.hamlet.R
import com.example.hamlet.adapters.EmployeeViewPagerAdapter
import com.example.hamlet.adapters.ProfileViewPagerAdapter
import com.example.hamlet.fragments.companyfragment.CompanyDetailsFragment
import com.example.hamlet.fragments.companyfragment.ManagerDetailsFragment
import com.example.hamlet.fragments.employeefragment.EmploymentInfoFragment
import com.example.hamlet.fragments.employeefragment.PersonalInfoFragment
import kotlinx.android.synthetic.main.activity_employees_details.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        setupTabs()
    }



    private fun setupTabs() {
        val adapter = ProfileViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ManagerDetailsFragment(), "Manager Profile")
        adapter.addFragment(CompanyDetailsFragment(), "Company Details")
        profile_viewPager.adapter = adapter
        profile_tab.setupWithViewPager(profile_viewPager)

    }

    fun goToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)


        startActivity(intent)
    }

}