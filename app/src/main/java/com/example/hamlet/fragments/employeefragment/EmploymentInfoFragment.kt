package com.example.hamlet.fragments.employeefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hamlet.R
import com.example.hamlet.model.EmployeeResponse


class EmploymentInfoFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_employment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {

            val employeeDetails = it.intent.getParcelableExtra<EmployeeResponse.User.Employee>("employeeDetails")
            val employeeJobCategory= view.findViewById<TextView>(R.id.jobCategory)
            val jobDescription = view.findViewById<TextView>(R.id.job_description)
            val employmentClassification = view.findViewById<TextView>(R.id.employment_classification)
            val employeeDepartment = view.findViewById<TextView>(R.id.departmentTv)
            val employeeWorkLocation = view.findViewById<TextView>(R.id.work_location)
            employeeJobCategory.text = employeeDetails?.jobDetails?.jobCategory
            jobDescription.text = employeeDetails?.jobDetails?.description
            employmentClassification.text = employeeDetails?.jobDetails?.employmentClassification
            employeeDepartment.text = employeeDetails?.jobDetails?.department
            employeeWorkLocation.text = employeeDetails?.jobDetails?.workLocation
        }

    }

}