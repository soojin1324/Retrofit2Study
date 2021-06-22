package com.soojin.retrofit2study.scenarios.articles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.soojin.retrofit2study.R
import com.soojin.retrofit2study.api.connector.ServerConnector
import com.soojin.retrofit2study.modules.ToastHelper

class ArticlesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        ServerConnector.getArticles { res ->
            if(res?.code == null)
                ToastHelper.showToast("알 수 없는 오류가 발생하였습니다.")
            else if(res.code != 0)
                ToastHelper.showToast(res.msg)
            else {
                //알아서 처음부터 끝까지 돌아감
                res.data.forEach {
                    val idx = it.idx
                    val nickname = it.nickname
                    val username = it.username
                    val message = it.message
                    val createdAt = it.createdAt //언제 적었는지
                    Log.d("GetArticle", "idx: $idx | message: $message - nickname: $nickname(${username}) [ $createdAt ]")
                }
            }
        }
    }
}