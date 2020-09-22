package com.example.hamlet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.example.hamlet.adapters.EmployeesAdapter
import com.example.hamlet.api.RetrofitClient
import com.example.hamlet.databinding.ActivityMainBinding
import com.example.hamlet.model.EmployeeResponse
import com.example.hamlet.model.User
import com.example.hamlet.ui.ProfileActivity
import kotlinx.android.synthetic.main.activity_employees_details.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.employees.*
import kotlinx.android.synthetic.main.employees.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var binding: ActivityMainBinding
lateinit var recyclerView: RecyclerView


class MainActivity : AppCompatActivity() {

    private val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        swipeRefreshLayout.isRefreshing = true

        // call api to reload the screen


    }

    lateinit var user: EmployeeResponse.User

    val employeesAdapter: EmployeesAdapter by lazy {
        EmployeesAdapter { employeeList ->
            Log.e("TAG", "employee list  $employeeList")
            val intent = Intent(applicationContext, EmployeesDetails::class.java).apply {
                putExtra("employeeDetails", employeeList)
            }

            startActivity(intent)


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        swipeRefreshLayout.setOnRefreshListener(refreshListener)
        swipeRefreshLayout.isRefreshing = false
        recyclerView = view.findViewById(R.id.recyclerView_id)
        recyclerView.adapter = employeesAdapter
        linearLayoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = linearLayoutManager
        RetrofitClient.instance.getAllEmployees(
            "Bearer " + SharedPrefManagerPrivate(
                applicationContext
            ).getToken()
        )
            .enqueue(object : Callback<EmployeeResponse> {
                override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    swipeRefreshLayout.isRefreshing = false
                    println("Failed to load employee list: ${t.message}")
                }

                override fun onResponse(
                    call: Call<EmployeeResponse>,
                    response: Response<EmployeeResponse>
                ) {

                    if (response.isSuccessful) {
                        user = response.body()!!.user

                        employeesAdapter.setItems(response.body()!!.user.employees)
                        swipeRefreshLayout.isRefreshing = false
                        Glide.with(this@MainActivity)
                            .load(response.body()!!.user.profile.profilePic)
                            .circleCrop()
                            .into(managers_picture)

                        managers_name.text = response.body()!!.user.profile.firstName


                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Failed to load employee list",
                            Toast.LENGTH_LONG
                        ).show()
                        println("Failed to load employee list: ${response.body()}")
                    }

                }
            })



        managers_picture.setOnClickListener {


            val intent = Intent(this, ProfileActivity::class.java).apply {
                Log.e("TAG", "employee list  ${employeesAdapter.employeeList}")
                putExtra("managerDetails", user)
            }

            startActivity(intent)
        }

    }



}