package com.example.hamlet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hamlet.model.Employees
import com.example.hamlet.R
import com.example.hamlet.model.Job_details
import kotlinx.android.synthetic.main.employees.view.*


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

    var first_name = itemView.first_name
    var last_name = itemView.lst_name
    var employees_profile_picture = itemView.profile_pic
    var employees_role = itemView.employee_role




    fun initialize(item: Employees,  action: OnEmployeesItemClickListener) {

        first_name.text = item.first_name

        employees_profile_picture.setImageResource(item.profile_pic)





        itemView.setOnClickListener {
            action.onItemClick(item, adapterPosition)
        }

    }


}

interface OnEmployeesItemClickListener {
    fun onItemClick(items: Employees, position: Int)

}