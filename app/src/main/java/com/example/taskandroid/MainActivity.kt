package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.dimenResponse.dimen_responsive
import com.example.taskandroid.drawable.DrawableMain
import com.example.taskandroid.drawable.customdrawable.MakecustomDrawable
import com.example.taskandroid.tasklayout.TaskLayoutMain
import com.example.taskandroid.taskactivity.TaskActivityMain

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
        //Button for the clicking 3. Drawable
        val drawableCustomBtn:Button =findViewById(R.id.btn3)
        drawableCustomBtn.setOnClickListener {
            val intent = Intent(this, DrawableMain::class.java)
            startActivity(intent)
        }
        //Button for the clicking 1. Activity
        val actLogBtn:Button =findViewById(R.id.btn1)
        actLogBtn.setOnClickListener {
            val intent = Intent(this, TaskActivityMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 2. layout
        val dataPassBtn:Button =findViewById(R.id.btn2)
        dataPassBtn.setOnClickListener {
            val intent = Intent(this, TaskLayoutMain::class.java)
            startActivity(intent)
        }
    }
}
