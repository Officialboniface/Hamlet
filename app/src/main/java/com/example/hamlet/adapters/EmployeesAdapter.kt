package com.example.hamlet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hamlet.Employees
import com.example.hamlet.R
import kotlinx.android.synthetic.main.employees.view.*
import kotlinx.android.synthetic.main.employees.view.employees_name


class EmployeesAdapter(
    var items: ArrayList<Employees>,
    var ClickListener: OnEmployeesItemClickListener
) : RecyclerView.Adapter<EmployeesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        lateinit var employeesViewHolder: EmployeesViewHolder

        employeesViewHolder = EmployeesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.employees, parent, false)
        )
        return employeesViewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {

        holder.initialize(items.get(position), ClickListener)

    }


}

class EmployeesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var employees_name = itemView.employees_name
//    var employees_dob = itemView.employees_dob_text
    var employees_profile_picture = itemView.employees_profile_picture
    var employees_role = itemView.employee_role




    fun initialize(item: Employees, action: OnEmployeesItemClickListener) {

        employees_name.text = item.employee_name
        employees_role.text = item.employee_role
        employees_profile_picture.setImageResource(item.employee_image)





        itemView.setOnClickListener {
            action.onItemClick(item, adapterPosition)
        }

    }


}

interface OnEmployeesItemClickListener {
    fun onItemClick(items: Employees, position: Int)

}