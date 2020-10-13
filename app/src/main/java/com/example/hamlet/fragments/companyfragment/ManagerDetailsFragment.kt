package com.example.hamlet.fragments.companyfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hamlet.R
import com.example.hamlet.model.EmployeeResponse
import kotlinx.android.synthetic.main.fragment_company_details.*
import kotlinx.android.synthetic.main.fragment_manager_details.*

class ManagerDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manager_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        activity?.let {


            val user =
                it.intent.getParcelableExtra<EmployeeResponse.User>("managerDetails")
            val managerEmail = view.findViewById<TextView>(R.id.managers_email)
            val companyName = view.findViewById<TextView>(R.id.manager_company_name)
            val managersPhone = view.findViewById<TextView>(R.id.manager_phone_number)
            val managersFirstName = view.findViewById<TextView>(R.id.managers_first_name)
            val managerAddress = view.findViewById<TextView>(R.id.manager_address)
            val managerLastName = view.findViewById<TextView>(R.id.managers_last_name)
            managersFirstName.text = user?.profile?.firstName
            managersPhone.text = user?.profile?.phone
            companyName.text = user?.company?.companyName
            managerAddress.text = user?.profile?.address
            managerLastName.text = user?.profile?.lastName
            managerEmail.text = user?.email

            Glide.with(this)
                .load(user?.profile?.profilePic)
                .circleCrop()
                .into(manager_picture)

        }


    }

}