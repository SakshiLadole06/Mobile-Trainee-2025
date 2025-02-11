package com.example.taskandroid.taskactivity.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("Tag","OnCreate Block Executed Successfully.")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Tag","OnStart Block Executed Successfully.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Tag","OnPause Block Executed Successfully.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Tag","onRestart Block Executed Successfully.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Tag","OnResume Block Executed Successfully.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Tag","OnStop Block Executed Successfully.")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Tag","OnDestroy Block Executed Successfully.")
    }
}