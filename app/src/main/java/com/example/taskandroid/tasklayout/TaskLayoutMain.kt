package com.example.taskandroid.tasklayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R
import com.example.taskandroid.tasklayout.constraintlayoutask.ConstraintLayoutProfilePage
import com.example.taskandroid.tasklayout.formwithscrolltask.LinearLayOutForm
import com.example.taskandroid.tasklayout.framelayouttask.FrameLayoutTask

class TaskLayoutMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task_layout_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Button for the clicking 1. Sign-Up Form
        val signUpBtn: Button =findViewById(R.id.signUpBtn)
        signUpBtn.setOnClickListener {
            val intent = Intent(this, LinearLayOutForm::class.java)
            startActivity(intent)
        }
        //Button for the clicking 2. Profile Page
        val profilePageBtn: Button =findViewById(R.id.profilePageBtn)
        profilePageBtn.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutProfilePage::class.java)
            startActivity(intent)
        }
        //Button for the clicking 3. Frame Layout
        val frameLayputBtn:Button =findViewById(R.id.frameLayputBtn)
        frameLayputBtn.setOnClickListener {
            val intent = Intent(this, FrameLayoutTask::class.java)
            startActivity(intent)
        }
    }
}
