package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.taskviewpager_tablayout.TaskViewpagerTabLayout
import com.example.taskandroid.dimenResponse.dimen_responsive
import com.example.taskandroid.drawable.DrawableMain
import com.example.taskandroid.drawable.customdrawable.MakecustomDrawable
import com.example.taskandroid.tasklayout.TaskLayoutMain
import com.example.taskandroid.taskactivity.TaskActivityMain
import com.example.taskandroid.taskfonts.TaskFontsMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPageTAbLayoutBtn: Button =findViewById(R.id.btn5)
        viewPageTAbLayoutBtn.setOnClickListener {
            val intent = Intent(this, TaskViewpagerTabLayout::class.java)
            startActivity(intent)
        }
        //Button for the clicking 4. Dimens for responsive design
        val demanResponseBtn: Button = findViewById(R.id.btn4)
        demanResponseBtn.setOnClickListener {
            val intent = Intent(this, dimen_responsive::class.java)
            startActivity(intent)
        }
        //Button for the clicking 3. Drawable
        val drawableCustomBtn: Button = findViewById(R.id.btn3)
        drawableCustomBtn.setOnClickListener {
            val intent = Intent(this, DrawableMain::class.java)
            startActivity(intent)
        }
        //Button for the clicking 1. Activity
        val fontBtn: Button = findViewById(R.id.btn8)
        fontBtn.setOnClickListener {
            val intent = Intent(this, TaskFontsMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 2. layout
        val dataPassBtn: Button = findViewById(R.id.btn2)
        dataPassBtn.setOnClickListener {
            val intent = Intent(this, TaskLayoutMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 2. layout
        val fontsBtn: Button = findViewById(R.id.btn8)
        dataPassBtn.setOnClickListener {
            val intent = Intent(this, TaskLayoutMain::class.java)
            startActivity(intent)
        }
    }
}
