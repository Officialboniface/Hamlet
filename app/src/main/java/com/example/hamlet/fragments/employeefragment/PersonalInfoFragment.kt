package com.example.hamlet.fragments.employeefragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hamlet.EmployeesDetails
import com.example.hamlet.R
import com.example.hamlet.model.EmployeeResponse
import kotlinx.android.synthetic.main.fragment_personal_info.*


class PersonalInfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        activity.intent.getParcelableExtra<EmployeesDetails>("employeeDetails")
        return inflater.inflate(R.layout.fragment_personal_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {

            val employeeDetails =
                it.intent.getParcelableExtra<EmployeeResponse.User.Employee>("employeeDetails")
            val employeeDOB = view.findViewById<TextView>(R.id.employees_dob_text)
            Log.e("TAG", "employee details  $employeeDetails")
            employeeDOB.text = employeeDetails?.dob
            val employeeQualification = view.findViewById<TextView>(R.id.qualification)
            val employeeEmail = view.findViewById<TextView>(R.id.email)
            val employeePhone = view.findViewById<TextView>(R.id.em_phone_number)
            val employeeGender = view.findViewById<TextView>(R.id.gender)
            val employeeEmergencyNumber = view.findViewById<TextView>(R.id.emergency_number)
            employeeGender.text = employeeDetails?.gender
            val employeeAddress = view.findViewById<TextView>(R.id.home_address)
            employeeAddress.text = employeeDetails?.address
            employeeEmail.text = employeeDetails?.contactInfo?.email
            employeePhone.text = employeeDetails?.contactInfo?.phone
            employeeQualification.text = employeeDetails?.qualification
            employeeEmergencyNumber.text = employeeDetails?.contactInfo?.emergencyContact

        }

    }

}