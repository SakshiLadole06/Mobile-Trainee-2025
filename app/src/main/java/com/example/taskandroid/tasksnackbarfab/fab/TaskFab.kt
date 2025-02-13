package com.example.taskandroid.tasksnackbarfab.fab

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskFab : AppCompatActivity() {
    private lateinit var fabBtn: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_fab)
        fabBtn=findViewById(R.id.fabBtn)
        fabBtn.setOnClickListener{
            Toast.makeText(this,"Floating Action Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}