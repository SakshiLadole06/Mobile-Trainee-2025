package com.example.taskandroid.tasksharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R
import com.example.taskandroid.taskintentfilter.TaskIntentFilterMain

class LoginPageSharedPreference : AppCompatActivity() {
    private lateinit var nameSharedPreference :EditText
    private lateinit var passwordSharedPreference :EditText
    private lateinit var logInSharedPreference :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page_shared_preference)

        //find ids
        nameSharedPreference = findViewById(R.id.nameSharedPreference)
        passwordSharedPreference = findViewById(R.id.passwordSharedPreference)
        logInSharedPreference = findViewById(R.id.logInSharedPreference)

        val shrPreTask = getSharedPreferences("login", MODE_PRIVATE)//instance of Shred Preference
        val shrPreEditTask = shrPreTask.edit() //its editor

        val isLoggedIn = shrPreTask.getBoolean("flag", false)//for login check

        // Skip login screen if user is already logged in
        if (isLoggedIn) {
            val intent = Intent(this, HomePageSharedPreference::class.java)
            startActivity(intent)
            finish()
        }

        logInSharedPreference.setOnClickListener {
            val name = nameSharedPreference.text.toString().trim()
            val password = passwordSharedPreference.text.toString().trim()

            if (name.isNotEmpty() && password.isNotEmpty()) {
                // Save user name in SharedPreferences
                shrPreEditTask.putBoolean("flag",true)
                shrPreEditTask.putString("nameUser", name)
                shrPreEditTask.apply()

                // Navigate to HomeActivity
                val intent = Intent(this, HomePageSharedPreference::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter name and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}