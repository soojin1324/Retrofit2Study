package com.soojin.retrofit2study.api

import com.soojin.retrofit2study.api.`interface`.APIServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServerRetrofit {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://gaobook.dothome.co.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val server: APIServer = retrofit.create(APIServer::class.java)
}