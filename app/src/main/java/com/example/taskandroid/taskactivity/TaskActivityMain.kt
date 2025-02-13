package com.example.taskandroid.taskactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R
import com.example.taskandroid.taskactivity.data_pass.DataPass
import com.example.taskandroid.taskactivity.lifecycle.LifeCycleActivity

class TaskActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Button for the clicking 1. Logcat
        val actLog:Button =findViewById(R.id.activitylog)
        actLog.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }
        //Button for the clicking 2.Data padd
        val dataPassBtn:Button =findViewById(R.id.passDataBtn)
        dataPassBtn.setOnClickListener {
            val intent = Intent(this, DataPass::class.java)
            startActivity(intent)
        }
    }
}