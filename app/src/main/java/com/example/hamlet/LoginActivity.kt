package com.example.hamlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hamlet.ui.ProfileActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun goToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)


        startActivity(intent)
    }
}