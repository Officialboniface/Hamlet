package com.example.hamlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hamlet.databinding.ActivityMainBinding
import com.example.hamlet.model.Employees
import com.example.hamlet.ui.ProfileActivity
import kotlinx.android.synthetic.main.activity_main.*


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


private fun showEmployees (employees: List<Employees>) {
    recyclerView_id.layoutManager = LinearLayoutManager(this)
}



    fun goToProfile(view: View) {

        val intent = Intent(this, ProfileActivity::class.java)

        startActivity(intent)
    }
}