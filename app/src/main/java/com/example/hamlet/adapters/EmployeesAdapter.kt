package com.example.hamlet.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hamlet.R
import com.example.hamlet.inflate
import com.example.hamlet.model.EmployeeResponse

import kotlinx.android.synthetic.main.employees.view.*
import java.lang.Character.toLowerCase
import java.util.*
import kotlin.collections.ArrayList


class EmployeesAdapter(
    private var filterEmployees: ArrayList<EmployeeResponse.User.Employee>,
    private val onClickHandler: OnSearchClick
) :
    RecyclerView.Adapter<EmployeesAdapter.AllEmployeesViewHolder>(), Filterable {


    var employeeList = ArrayList<EmployeeResponse.User.Employee>()

    init {
        filterEmployees = employeeList
    }

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
                onClickHandler.onClick(employeeList)
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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    employeeList = filterEmployees
                } else {
                    val resultList = ArrayList<EmployeeResponse.User.Employee>()
                    for (row in filterEmployees) {
                        if (row.firstName.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        } else if (row.otherNames.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    employeeList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = employeeList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                employeeList = results?.values as ArrayList<EmployeeResponse.User.Employee>
                notifyDataSetChanged()
            }

        }
    }


    interface OnSearchClick {
        fun onClick(employee: EmployeeResponse.User.Employee)

    }

}


