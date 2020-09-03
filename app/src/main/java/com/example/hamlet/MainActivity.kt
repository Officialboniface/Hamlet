package com.example.hamlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hamlet.api.RetrofitClient
import com.example.hamlet.databinding.ActivityMainBinding
import com.example.hamlet.model.Employees
import com.example.hamlet.model.EmployeesList
import com.example.hamlet.ui.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import com.example.hamlet.adapters.EmployeesAdapter as EmployeesAdapter

private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }


private fun showEmployees (employees: List<Employees>) {

    linearLayoutManager = LinearLayoutManager(this)
    recyclerView_id.layoutManager = linearLayoutManager
}



    fun goToProfile(view: View) {

        val intent = Intent(this, ProfileActivity::class.java)

        startActivity(intent)
    }
}