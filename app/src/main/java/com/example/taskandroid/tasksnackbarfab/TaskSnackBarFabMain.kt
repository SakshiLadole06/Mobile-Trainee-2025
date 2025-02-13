package com.example.taskandroid.tasksnackbarfab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import com.example.taskandroid.tasksnackbarfab.fab.TaskFab
import com.example.taskandroid.tasksnackbarfab.snackbar.TaskSnackBar

class TaskSnackBarFabMain : AppCompatActivity() {
    private lateinit var btnForSnackBar:Button
    private lateinit var btnForFab:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_snackbar_fab_main)
        btnForSnackBar=findViewById(R.id.btnForSnakeBar)
        btnForSnackBar.setOnClickListener{
            val intent=Intent(this,TaskSnackBar::class.java)
            startActivity(intent)
        }
        btnForFab=findViewById(R.id.btnForFab)
        btnForFab.setOnClickListener{
            val intent=Intent(this,TaskFab::class.java)
            startActivity(intent)
        }
    }
}