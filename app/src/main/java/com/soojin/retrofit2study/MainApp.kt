package com.soojin.retrofit2study

import android.app.Application
import android.content.Context

//앱이 끝날 때 까지 존재함
class MainApp: Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}