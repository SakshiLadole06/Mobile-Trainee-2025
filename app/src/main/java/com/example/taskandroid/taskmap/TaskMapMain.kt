package com.example.taskandroid.taskmap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R

class TaskMapMain : AppCompatActivity() {
    private lateinit var map1:Button
    private lateinit var map2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_map_main)
        //find ids
        map1=findViewById(R.id.map1)
        map1.setOnClickListener{
            val intent=Intent(this,NormalMap::class.java)
            startActivity(intent)
        }
        map2=findViewById(R.id.map2)
        map2.setOnClickListener{
            val intent=Intent(this,MarkerMap::class.java)
            startActivity(intent)
        }
    }
}