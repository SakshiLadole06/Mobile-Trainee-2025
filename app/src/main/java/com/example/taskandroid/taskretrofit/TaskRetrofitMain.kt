package com.example.taskandroid.taskretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class TaskRetrofitMain : AppCompatActivity() {
    private lateinit var recycleViewRetrofit: RecyclerView
    private lateinit var progressBarRetrofit:ProgressBar
    private lateinit var postReq:Button

    //url of API
    val url = "https://jsonplaceholder.typicode.com/"
    val post_url="https://fakestoreapi.com/"

    //variable for adapter
    lateinit var adapter: RetroFitAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_retrofit_main)
        //find id
        recycleViewRetrofit = findViewById(R.id.recycleViewRetrofit)
        progressBarRetrofit = findViewById(R.id.progressBarRetrofit)
        postReq = findViewById(R.id.postReq)

        recycleViewRetrofit.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recycleViewRetrofit.layoutManager = linearLayoutManager

        getData()

        postReq.setOnClickListener{
            postData("mor_2314","83r5^_")
        }
    }

    private fun getData() {
        val RetroFitBuilder = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        val objRetrofitGet = RetroFitBuilder.getDataFromAPI()

        objRetrofitGet?.enqueue(object : Callback<MutableList<RetroFitDataClass?>?>{
            override fun onResponse(call: Call<MutableList<RetroFitDataClass?>?>,response: Response<MutableList<RetroFitDataClass?>?>){
                progressBarRetrofit.setVisibility(View.GONE)
                try{
                    if (response.isSuccessful && response.body() != null) {
                        val response = response.body()!!
                        adapter = RetroFitAdapter(baseContext, response)
                        adapter.notifyDataSetChanged()
                        recycleViewRetrofit.adapter = adapter
                    }
                    else{
                        Toast.makeText(this@TaskRetrofitMain,"Error Occurred: ${response.message()}",Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception) {
                    Toast.makeText(this@TaskRetrofitMain,"Error Occurred: ${e.message}",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<MutableList<RetroFitDataClass?>?>, t: Throwable) {
                //Log.d("Tag","onFailure : "+t.message)
                Toast.makeText(this@TaskRetrofitMain,"Error Occurred: ${t.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun postData(username:String,password:String){
        val RetroFitBuilder = Retrofit.Builder()
            .baseUrl(post_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)

        // calling a method to create a post and passing our modal class.
        val objRetrofitPost = RetroFitBuilder.postDataFromAPI(PostRequestRetrofitDataClass(username, password))

        objRetrofitPost?.enqueue(object : Callback<PostResponseRetrofitDataClass>{
            override fun onResponse(
                call: Call<PostResponseRetrofitDataClass>,
                response: Response<PostResponseRetrofitDataClass>
            ) {
                try{
                    if (response.isSuccessful && response.body() != null) {
                        val response = response.body()!!
                        //Log.d("Tag","output ${response}") By default response token print krte
                        Toast.makeText(this@TaskRetrofitMain, "Correct Data", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Log.d("Tag","output ${response.code()}")
                        Toast.makeText(this@TaskRetrofitMain,"Incorrect Data: ${response.code()}",Toast.LENGTH_SHORT).show()
                    }
                }
                catch (e: Exception) {
                    Toast.makeText(this@TaskRetrofitMain,"Error Occurred In Try Catch Block:\n${e.message}",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PostResponseRetrofitDataClass>, t: Throwable) {
                Toast.makeText(this@TaskRetrofitMain, "Error Occurred When Failure:\n${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
