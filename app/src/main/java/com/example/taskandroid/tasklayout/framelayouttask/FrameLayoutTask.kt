package com.example.taskandroid.tasklayout.framelayouttask

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R

class FrameLayoutTask : AppCompatActivity() {
    private lateinit var red:View
    private lateinit var green:View
    private lateinit var white:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout_task)
        //For red view
        red = findViewById(R.id.red)
        red.setOnClickListener(View.OnClickListener { view->
            red.visibility = View.GONE
        })
        //For green view
        green = findViewById(R.id.green)
        green.setOnClickListener(View.OnClickListener { view->
            green.visibility = View.GONE
        })
        //For white view
        white = findViewById(R.id.white)
        white.setOnClickListener(View.OnClickListener { view->
            white.visibility = View.GONE
        })
    }
}