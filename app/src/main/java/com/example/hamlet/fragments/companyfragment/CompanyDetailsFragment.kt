package com.example.hamlet.fragments.companyfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hamlet.R
import com.example.hamlet.model.EmployeeResponse
import kotlinx.android.synthetic.main.fragment_company_details.*

class CompanyDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {


            val user =
                it.intent.getParcelableExtra<EmployeeResponse.User>("managerDetails")
            Log.e("TAG", "companyDetails  $user")
            val companyPhone = view.findViewById<TextView>(R.id.company_phone_number)
            val companyService = view.findViewById<TextView>(R.id.company_service)
            val companyWebsite = view.findViewById<TextView>(R.id.company_website)
            val companyEmail = view.findViewById<TextView>(R.id.company_email)
            val companyZipCode = view.findViewById<TextView>(R.id.company_zip_code)
            val numOfEmployees = view.findViewById<TextView>(R.id.total_employees)
            val companyCity = view.findViewById<TextView>(R.id.city)
            val companyState = view.findViewById<TextView>(R.id.company_state)
            val companyAddress = view.findViewById<TextView>(R.id.company_address)
            val companyName = view.findViewById<TextView>(R.id.company_name)
            companyName.text = user?.company?.companyName
            companyPhone.text = user?.company?.companyPhone
            companyService.text = user?.company?.services
            companyWebsite.text = user?.company?.companyWebsite
            companyEmail.text = user?.company?.companyEmail
            companyZipCode.text = user?.company?.zipCode
            numOfEmployees.text = user?.company?.noOfEmployees
            companyState.text = user?.company?.state
            companyCity.text = user?.company?.city
            companyAddress.text = user?.company?.companyAddress

            Glide.with(this)
                .load(user?.company?.companyLogo)
                .circleCrop()
                .into(company_picture)

        }

    }

}