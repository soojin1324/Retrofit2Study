package com.soojin.retrofit2study.modules

import android.widget.Toast
import com.soojin.retrofit2study.MainApp

object ToastHelper {
    fun showToast(msg: String) {
        Toast.makeText(MainApp.context, msg, Toast.LENGTH_SHORT).show()
    }
}