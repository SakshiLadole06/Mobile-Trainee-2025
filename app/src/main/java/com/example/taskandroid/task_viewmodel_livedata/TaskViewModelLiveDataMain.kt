package com.example.taskandroid.task_viewmodel_livedata

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.taskandroid.R
import kotlinx.coroutines.cancel

class TaskViewModelLiveDataMain : AppCompatActivity() {
    private lateinit var tv:TextView
    private lateinit var et:EditText
    private lateinit var b1:Button
    private lateinit var b2:Button
    private lateinit var timerViewModel:CountdownViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_viewmodel_livedata_main)
        //find ids
        tv=findViewById(R.id.tvViewModel)
        et=findViewById(R.id.etViewModel)
        b1=findViewById(R.id.viewModelB1)
        b2=findViewById(R.id.viewModelB2)

        // Initialize the ViewModel
        timerViewModel = ViewModelProvider(this).get(CountdownViewModel::class.java)

        // Observe the CountDown LiveData
        timerViewModel.timer.observe(this, Observer { timer ->
            tv.text = "Time Left : ${timer}s"
        })

        var flag=false
        b1.setOnClickListener{
            //Take Starting Timer form user
            val countDown = et.text.toString().trim().toIntOrNull() ?: 0
            if(!flag) {
                flag = true
                timerViewModel.startTimer(countDown)
                et.text.clear()
            }
            else {
                flag=false
                Toast.makeText(this, "Timer is already Started", Toast.LENGTH_SHORT).show()
            }
        }

        b2.setOnClickListener {
            timerViewModel.stopTimer()
            flag=false
        }
    }
}