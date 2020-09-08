package com.example.hamlet.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hamlet.R
import com.example.hamlet.inflate
import com.example.hamlet.model.EmployeeResponse

import kotlinx.android.synthetic.main.employees.view.*


class EmployeesAdapter (private val onClickHandler: ((EmployeeResponse.User.Employee) -> Unit) = {}) :
    RecyclerView.Adapter<EmployeesAdapter.AllEmployeesViewHolder>() {

    var employeeList = ArrayList<EmployeeResponse.User.Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllEmployeesViewHolder {
        return AllEmployeesViewHolder(parent.inflate(R.layout.employees))
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeesAdapter.AllEmployeesViewHolder, position: Int) {
        var employeeList = employeeList[position]
        holder.bind(employeeList)
    }

    inner class AllEmployeesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(employeeList: EmployeeResponse.User.Employee) {
            itemView.setOnClickListener {
                onClickHandler(employeeList)
            }

            itemView.first_name.text = employeeList.firstName
            itemView.last_name.text = employeeList.otherNames
            itemView.job_title.text = employeeList.jobDetails.jobTitle

            Glide.with(itemView.context)
                .load(employeeList.profilePic)
                .circleCrop()
                .into(itemView.profile_pic)




        }

    }


    fun setItems(items: List<EmployeeResponse.User.Employee>) {
        this.employeeList.clear()
        this.employeeList.addAll(items)
        notifyDataSetChanged()
    }


}