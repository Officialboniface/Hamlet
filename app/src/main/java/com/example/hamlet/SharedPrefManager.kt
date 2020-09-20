package com.example.hamlet

import android.content.Context

class SharedPrefManagerPrivate constructor(private val mCtx: Context) {

    companion object {
        const val USER_SHARED_PREF = "hamlet_android_app"
    }
    private val sharedPref = mCtx.getSharedPreferences(USER_SHARED_PREF, Context.MODE_PRIVATE)

    /**
     * save user token in sharedPreference
     */
     fun saveToken(token: String) {
        sharedPref.edit().putString("token", token).apply()
    }

    /**
     * get saved user token from sharedPreference
     */
     fun getToken(): String = sharedPref.getString("token", "") ?: ""


}

