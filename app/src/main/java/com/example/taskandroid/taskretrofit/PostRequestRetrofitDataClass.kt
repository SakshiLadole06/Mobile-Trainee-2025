package com.example.taskandroid.taskretrofit

data class PostRequestRetrofitDataClass(
    val username:String,
    val password:String
)

data class PostResponseRetrofitDataClass(
    val token:String
)