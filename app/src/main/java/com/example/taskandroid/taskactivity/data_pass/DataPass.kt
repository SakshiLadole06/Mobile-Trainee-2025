package com.example.taskandroid.taskactivity.data_pass

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R
import com.example.taskandroid.taskactivity.lifecycle.LifeCycleActivity

class DataPass : AppCompatActivity() {
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//        val msgName=intent.getStringExtra("Name")
//        val msgAge=intent.getStringExtra("Age")
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val text = data?.getStringExtra("Name") +" "+ data?.getStringExtra("Age")
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pass)
        //Button for the clicking 1. Move to the data page
        val moveNextPageBtn:Button =findViewById(R.id.moveNextPageBtn)
        moveNextPageBtn.setOnClickListener {
            val intent = Intent(this, SecondActivityGetDataAndPaasIt::class.java)
            resultLauncher.launch(intent)
        }
    //My way of toast
//        val msgName=intent.getStringExtra("Name")
//        val msgAge=intent.getStringExtra("Age")
//        val text = msgName+" "+msgAge
//        val duration = Toast.LENGTH_SHORT
//
//        val toast = Toast.makeText(this, text, duration) // in Activity
//        toast.show()
    }
}