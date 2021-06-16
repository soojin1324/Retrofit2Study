package com.soojin.retrofit2study.api.`interface`

import com.soojin.retrofit2study.api.model.getSignIn.GetSignInRes
import com.soojin.retrofit2study.api.model.getSignup.GetSignUpRes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIServer {
    @GET("http://gaobook.dothome.co.kr/api/signin.php")
    fun getSignIn(@Query("username")username: String,
                  @Query("password")password: String): Call<GetSignInRes>

    @GET("http://gaobook.dothome.co.kr/api/signup.php")
    fun getSignUp(@Query("nickname") nickname: String,
                  @Query("username") username: String,
                  @Query("password") password: String): Call<GetSignUpRes>
}