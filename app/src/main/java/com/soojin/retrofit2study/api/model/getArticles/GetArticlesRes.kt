package com.soojin.retrofit2study.api.model.getArticles

import retrofit2.http.Field

data class GetArticlesRes (
    val code: Int,
    val msg: String,
    val data: List<Data>
)

