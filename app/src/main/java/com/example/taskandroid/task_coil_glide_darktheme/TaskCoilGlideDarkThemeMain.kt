package com.example.taskandroid.task_coil_glide_darktheme

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import coil3.load
import com.bumptech.glide.Glide
import com.example.taskandroid.R

class TaskCoilGlideDarkThemeMain : AppCompatActivity() {
    private lateinit var imageView1:ImageView
    private lateinit var imageView2:ImageView
    private lateinit var radioGrp:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_coil_glide_dark_theme_main)
        //find id
        imageView1=findViewById(R.id.imageView1)
        imageView2=findViewById(R.id.imageView2)
        radioGrp=findViewById(R.id.radioGroup1)

        imageView1
            .load("https://www.goodworklabs.com/wp-content/uploads/2017/08/2b-8-android-apps-to-study-for-upcoming-developers.jpg")

        Glide.with(this)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSItJ82eLYtecwr5DbSnf6V1TXt2rancpDWOA&s")
            .placeholder(R.drawable.downloading)
            .into(imageView2)


        radioGrp.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.light ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                R.id.dark ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

                R.id.systemDefault ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }
}