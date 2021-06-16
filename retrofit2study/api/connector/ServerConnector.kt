package com.soojin.retrofit2study.api.connector

import android.util.Log
import android.widget.Toast
import com.soojin.retrofit2study.api.ServerRetrofit
import com.soojin.retrofit2study.api.model.getSignIn.GetSignInRes
import com.soojin.retrofit2study.api.model.getSignup.GetSignUpRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServerConnector {
    const val TAG = "ServerConnector"

    fun getSignIn(username: String, password: String, onResponse: (GetSignInRes?) -> Unit) {
        ServerRetrofit.server.getSignIn(username, password).enqueue(object :
            Callback<GetSignInRes> {
            override fun onResponse(call: Call<GetSignInRes>, response: Response<GetSignInRes>) {
                onResponse(response.body())
//                val body = response.body()!!
//                Log.d(TAG, "onResponse - getSignIn: ${body.msg}/${body.code}")
            }

            override fun onFailure(call: Call<GetSignInRes>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getSignUp(nickname: String, username: String, password: String) {
        ServerRetrofit.server.getSignUp(nickname, username, password).enqueue(object : Callback<GetSignUpRes> {
            override fun onResponse(call: Call<GetSignUpRes>, response: Response<GetSignUpRes>) {
                Log.d(TAG, "onResponse: ${response.body()!!.msg}")
            }

            override fun onFailure(call: Call<GetSignUpRes>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }


}