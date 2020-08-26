package com.example.hamlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hamlet.databinding.ActivityMainBinding
import com.example.hamlet.ui.ProfileActivity

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }





    fun goToProfile(view: View) {

        val intent = Intent(this, ProfileActivity::class.java)


        startActivity(intent)
    }
}