package com.soojin.retrofit2study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soojin.retrofit2study.api.connector.ServerConnector

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nickname = "수진"
        val username = "soso"
        val password = "soso123"

        ServerConnector.getSignUp(nickname, username, password)
//        ServerConnector.getSignIn("pcm123", "password123")
    }
}