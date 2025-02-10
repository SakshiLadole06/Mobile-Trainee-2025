package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.taskviewpager_tablayout.TaskViewpagerTabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Button for the clicking 5. ViewPager and TabLayout
        val viewPageTAbLayoutBtn: Button =findViewById(R.id.btn5)
        viewPageTAbLayoutBtn.setOnClickListener {
            val intent = Intent(this, TaskViewpagerTabLayout::class.java)
            startActivity(intent)
        }
    }
}
