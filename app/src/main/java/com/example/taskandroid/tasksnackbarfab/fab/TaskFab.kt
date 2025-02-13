package com.example.taskandroid.tasksnackbarfab.fab

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskFab : AppCompatActivity() {
    private lateinit var fabBtn: FloatingActionButton
    private lateinit var fabBtnUp: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_fab)
        fabBtn=findViewById(R.id.fabBtn)
        fabBtn.setOnClickListener{
            fabBtnUp.visibility=View.VISIBLE
//            Toast.makeText(this,"Floating Action Button Clicked", Toast.LENGTH_SHORT).show()
        }

        

        //For Up button
        fabBtnUp=findViewById(R.id.fabBtnUp)
        fabBtnUp.visibility= View.INVISIBLE
        fabBtnUp.setOnClickListener{
            Toast.makeText(this,"Floating Action Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}