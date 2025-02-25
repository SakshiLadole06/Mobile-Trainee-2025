package com.example.taskandroid.tasksharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R

class HomePageSharedPreference : AppCompatActivity() {
    private lateinit var showNameShrPre :TextView
    private lateinit var logOutSharedPreference:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_shared_preference)

        //Find ids
        showNameShrPre = findViewById(R.id.showNameShrPre)
        logOutSharedPreference = findViewById(R.id.logOutSharedPreference)

        val shrPreTask = getSharedPreferences("login", MODE_PRIVATE)//instance of Shred Preference
        val shrPreEditTask = shrPreTask.edit() //its editor

        // get username
        //contains(String key): This method is used to check whether the preferences contain a preference.
        //instead of this we can use this method
        val username = shrPreTask.getString("nameUser", "User")
        // Display greeting message
        showNameShrPre.text = "Welcome, $username! 🎉"

        logOutSharedPreference.setOnClickListener{
            //to dlt saved data
            shrPreEditTask.clear().apply()
            shrPreEditTask.putBoolean("flag",false).apply()
            val intent = Intent(this, LoginPageSharedPreference::class.java)
            startActivity(intent)
            finish()
        }
    }
}