package com.soojin.retrofit2study.scenarios.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.soojin.retrofit2study.R
import com.soojin.retrofit2study.api.connector.ServerConnector
import com.soojin.retrofit2study.modules.ToastHelper.showToast
import com.soojin.retrofit2study.scenarios.articles.ArticlesActivity
import com.soojin.retrofit2study.scenarios.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var llSignUp: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initUI()
        initLister()
    }

    private fun initUI() {
        edtUsername = findViewById(R.id.edt_signIn_username)
        edtPassword = findViewById(R.id.edt_signIn_password)
        btnSignIn = findViewById(R.id.btn_signIn)
        llSignUp = findViewById(R.id.ll_signIn_signUp)
    }

    private fun initLister() {
        btnSignIn.setOnClickListener {
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()

            ServerConnector.getSignIn(username, password) {
                if(it == null)
                    showToast("서버 오류가 발생하였습니다.")
                else if(it?.code != 0)
                    showToast(it?.msg)
                else
                    showToast("로그인 성공!")
                    startActivity(Intent(this, ArticlesActivity::class.java))
                    finish()
            }
        }

        llSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

}