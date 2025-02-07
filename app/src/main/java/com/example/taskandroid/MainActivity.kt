package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.dimenResponse.dimen_responsive

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Button for the clicking 4. Dimens for responsive design
        val demanResponseBtn:Button =findViewById(R.id.btn4)
        demanResponseBtn.setOnClickListener {
            val intent = Intent(this, dimen_responsive::class.java)
            startActivity(intent)
        }
    }
}
