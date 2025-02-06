package com.example.taskandroid.drawable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R
import com.example.taskandroid.drawable.customdrawable.MakecustomDrawable
import com.example.taskandroid.drawable.customselector.CustomDrawableSelector
//import com.example.taskandroid.taskactivity.TaskActivityMain
//import com.example.taskandroid.tasklayout.TaskLayoutMain

class DrawableMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable_main)
        //Button for the clicking 1. Custom Drawable
        val CustomDrawableBtn: Button =findViewById(R.id.CustomDrawableBtn)
        CustomDrawableBtn.setOnClickListener {
            val intent = Intent(this, MakecustomDrawable::class.java)
            startActivity(intent)
        }
        //Button for the clicking 2. Custom Drawable Selector
        val CustomSelectorBtn: Button =findViewById(R.id.CustomSelectorBtn)
        CustomSelectorBtn.setOnClickListener {
            val intent = Intent(this, CustomDrawableSelector::class.java)
            startActivity(intent)
        }
    }
}