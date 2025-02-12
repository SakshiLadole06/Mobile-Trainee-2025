package com.example.taskandroid.tasklayout.formwithscrolltask

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R

class LinearLayOutForm : AppCompatActivity() {
    private lateinit var submitBtn: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_lay_out_form)
        progressBar=findViewById(R.id.progressBarBTN)
        submitBtn=findViewById(R.id.submitBtn)
        progressBar=findViewById(R.id.progressBarBTN)
        submitBtn=findViewById(R.id.submitBtn)
        progressBar.visibility = View.GONE
        submitBtn.setOnClickListener({ view->
            submitBtn.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
            progressBar.visibility = View.GONE
            submitBtn.visibility = View.VISIBLE
                }, 5000)
        submitBtn.visibility = View.GONE

        })
    }
}