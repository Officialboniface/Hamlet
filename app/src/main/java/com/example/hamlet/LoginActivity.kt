package com.example.hamlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hamlet.api.ApiServices
import com.example.hamlet.api.RetrofitClient
import com.example.hamlet.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_Btn.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if(email.isEmpty()){
                etEmail.error = "Email required"
                etEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                etPassword.error = "Password required"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            /*val service = getRetrofit.create(ApiServices::class.java)
            val call = service.login(email, password)*/

            RetrofitClient.instance.loginUser(email, password)
                .enqueue(object: Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        println("Login Failure: ${t.message}")
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                        if(response.isSuccessful){

                            //SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)

                            /**
                             * save logged in user token
                             */
                            SharedPrefManagerPrivate(applicationContext).saveToken(response.body()!!.token)

                            val intent = Intent(applicationContext, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(intent)


                        }else{
                            Toast.makeText(applicationContext, "Login Fail: ${response.errorBody()}", Toast.LENGTH_LONG).show()
                            println("Login Fail: ${response.body()}")
                        }

                    }
                })


        }
    }
}