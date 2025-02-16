package com.example.taskandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.taskviewpager_tablayout.TaskViewpagerTabLayout
import com.example.taskandroid.dimenResponse.dimen_responsive
import com.example.taskandroid.drawable.DrawableMain
import com.example.taskandroid.task_appbar_toolbar.TaskAppbarToolbarMain
import com.example.taskandroid.tasklayout.TaskLayoutMain
import com.example.taskandroid.taskactivity.TaskActivityMain
import com.example.taskandroid.tasksnackbarfab.TaskSnackBarFabMain
import com.example.taskandroid.taskfonts.TaskFontsMain
import com.example.taskandroid.tc.TaskFragmentsMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button for the clicking 1. Activity
        val actLogBtn: Button = findViewById(R.id.btn1)
        actLogBtn.setOnClickListener {
            val intent = Intent(this, TaskActivityMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 2. layout
        val layoutBtn: Button = findViewById(R.id.btn2)
        layoutBtn.setOnClickListener {
            val intent = Intent(this, TaskLayoutMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 3. Drawable
        val drawableCustomBtn: Button = findViewById(R.id.btn3)
        drawableCustomBtn.setOnClickListener {
            val intent = Intent(this, DrawableMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 4. Dimens for responsive design
        val demanResponseBtn: Button = findViewById(R.id.btn4)
        demanResponseBtn.setOnClickListener {
            val intent = Intent(this, dimen_responsive::class.java)
            startActivity(intent)
        }

        //Button for the clicking 5. ViewPager and TabLayout
        val viewPageTAbLayoutBtn: Button =findViewById(R.id.btn5)
        viewPageTAbLayoutBtn.setOnClickListener {
            val intent = Intent(this, TaskViewpagerTabLayout::class.java)
            startActivity(intent)
        }

        //Button for the clicking 6. AppBar and ToolBar
        val appBarToolBarBtn: Button = findViewById(R.id.btn6)
        appBarToolBarBtn.setOnClickListener {
            val intent = Intent(this, TaskAppbarToolbarMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 7. Task SnackBar Fab
        val snackbarFabbtn: Button = findViewById(R.id.btn7)
        snackbarFabbtn.setOnClickListener {
            val intent = Intent(this, TaskSnackBarFabMain::class.java)
            startActivity(intent)
        }
        
        //Button for the clicking 8. Fonts
        val FontBtn: Button = findViewById(R.id.btn8)
        FontBtn.setOnClickListener {
            val intent = Intent(this, TaskFontsMain::class.java)
            startActivity(intent)
        }

        //Button for the clicking 10.Fragments
        val fragBtn: Button = findViewById(R.id.btn10)
        fragBtn.setOnClickListener {
            val intent = Intent(this, TaskFragmentsMain::class.java)
            startActivity(intent)
        }
    }
}
