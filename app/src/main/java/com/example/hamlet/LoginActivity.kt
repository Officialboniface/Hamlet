package com.example.hamlet

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hamlet.api.ApiCalls
import com.example.hamlet.api.AppConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {
//    val progressDialog = ProgressDialog(applicationContext)

     lateinit var sessionManager: SessionManager
    var name: String = ""
    var pass: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sessionManager = com.example.hamlet.SessionManager(this)
        var button: Button
//
//        var name: String = ""
//        var pass: String = ""

        val nm = findViewById(R.id.email) as EditText
        val ps = findViewById(R.id.pass) as EditText




//        name = nm.text.toString()
//        pass = ps.text.toString()


        button = findViewById(R.id.cirLoginButton) as Button
        button.setOnClickListener{
//            progressDialog.setTitle("Welcome to Hamlet")
//            progressDialog.setMessage("Application is loading, please wait")
//
//
//            progressDialog.show()
            name = nm.text.toString()
            pass = ps.text.toString()


            if (TextUtils.isEmpty(name)) {
                Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
                return@setOnClickListener;
            }
            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
                return@setOnClickListener;
            }


            getApi(name,pass)


        }

    }
    // Call<Hero> call = api.hero("postman","password");

    private fun getApi(email:String, pass:String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build()
        val api = retrofit.create(ApiCalls::class.java)
        // Call<Hero> call = api.hero("postman","password");
        val call = api.loginUser(email, pass)
        // Call<LoginInfo> call = api.hero("admin@gmail.com","Hamlet2020");
        call.enqueue(object:Callback<ApiCalls.LoginResponse> {
            override fun onResponse(call:Call<ApiCalls.LoginResponse>, response:Response<ApiCalls.LoginResponse>) {
                val loginInfoList = response.body()
                if (response.isSuccessful()){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("name", name)
                    startActivity(intent)
// Toast.makeText(getApplicationContext(), loginInfoList!!.token, Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss()

                    sessionManager.saveAuthToken(loginInfoList!!.token)
                    // Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();// Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Wrong Details", Toast.LENGTH_SHORT).show()
                // Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();
            }




            override fun onFailure(call:Call<ApiCalls.LoginResponse>, t:Throwable) {
                Toast.makeText(getApplicationContext(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}