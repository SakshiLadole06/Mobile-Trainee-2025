package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.drawable.DrawableMain
import com.example.taskandroid.drawable.customdrawable.MakecustomDrawable
//import com.example.taskandroid.taskactivity.TaskActivityMain
//import com.example.taskandroid.tasklayout.TaskLayoutMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button for the clicking 3. Drawable
        val drawableCustomBtn:Button =findViewById(R.id.btn3)
        drawableCustomBtn.setOnClickListener {
            val intent = Intent(this, DrawableMain::class.java)
            startActivity(intent)
        }
    }
}