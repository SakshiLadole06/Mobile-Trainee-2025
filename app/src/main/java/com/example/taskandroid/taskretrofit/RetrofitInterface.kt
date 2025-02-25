//Interface for the declare method which is use for the fetch data from api
package com.example.taskandroid.taskretrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitInterface{
    @GET("users")
    //By defalut ass aal
    //fun getDataFromAPI(@Path("users") user: String?): Call<MutableList<RetroFitDataClass?>?>?
    fun getDataFromAPI(): Call<MutableList<RetroFitDataClass?>?>?

    //Post
    @POST("auth/login")
    fun postDataFromAPI(@Body post: PostRequestRetrofitDataClass):Call<PostResponseRetrofitDataClass>
}