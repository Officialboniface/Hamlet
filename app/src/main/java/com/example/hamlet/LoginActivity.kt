package com.example.hamlet

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hamlet.api.RetrofitClient
import com.example.hamlet.model.LoginResponse
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {


    private var emailPattern = "[a-zA-Z0-9._-]" + "+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Progress Dialog
        val progressDialog = ProgressDialog(this)




        // Login Button
        login_Btn.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email can't be empty"
                etEmail.requestFocus()
                return@setOnClickListener

            } else {
                if (email.trim() { it <= ' ' }.matches(emailPattern.toRegex())) {
                    //NoToast
                } else {
                    // SnackBar
                    val snackBar = Snackbar.make(
                        it,
                        "Invalid Email",
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null)
                    snackBar.setActionTextColor(Color.WHITE)
                    val snackBarView = snackBar.view
                    snackBarView.setBackgroundColor(Color.RED)
                    snackBar.show()
                    return@setOnClickListener
                }
            }


            if (password.isEmpty()) {
                etPassword.error = "Password can't be empty"
                etPassword.requestFocus()

                return@setOnClickListener
            }


            if (!checkNetwork(this)){
                // SnackBar
                val snackBar = Snackbar.make(
                    it,
                    "No Internet Connection",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null)
                snackBar.setActionTextColor(Color.WHITE)
                val snackBarView = snackBar.view
                snackBarView.setBackgroundColor(Color.RED)
                snackBar.show()
                
                return@setOnClickListener
            }

            // Trigger Progress Dialog
            progressDialog.setMessage("Please wait!!!")
            progressDialog.setCancelable(false)
            progressDialog.show()



            RetrofitClient.instance.loginUser(email, password)

                .enqueue(object : Callback<LoginResponse> {

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        println("Login Failed: ${t.message}")
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>

                    ) {

                        if (response.isSuccessful) {


                            /**
                             * save logged in user token
                             */
                            SharedPrefManagerPrivate(applicationContext).saveToken(response.body()!!.token)

                            // Dismiss progress dialog
                            progressDialog.dismiss()

                            val intent = Intent(applicationContext, MainActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                            startActivity(intent)


                        } else {

                          // SnackBar
                            val snackBar = Snackbar.make(
                                it,
                                "Incorrect Email Or Password",
                                Snackbar.LENGTH_LONG
                            ).setAction("Action", null)
                            snackBar.setActionTextColor(Color.WHITE)
                            val snackBarView = snackBar.view
                            snackBarView.setBackgroundColor(Color.RED)
                            snackBar.show()

                            //Dismiss progress dialog
                            progressDialog.dismiss()
//                            println("Login Failed: ${response.body()}")
                        }


                    }
                })


        }


    }

    @SuppressLint("NewApi")
    private fun checkNetwork(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null){
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            }
        }

        return false

    }

}