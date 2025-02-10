package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.taskactivity.TaskActivityMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //Button for the clicking 1. Activity
        val actLogBtn:Button =findViewById(R.id.btn1)
        actLogBtn.setOnClickListener {
            val intent = Intent(this, TaskActivityMain::class.java)
            startActivity(intent)
        }

    }
}
