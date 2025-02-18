package com.example.taskandroid.taskrecycleview

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class TaskRecycleViewMain : AppCompatActivity() {
    private lateinit var recycleView:RecyclerView
    private lateinit var checkBoxForRecycleView: CheckBox
    private lateinit var editTextForRecycleView: EditText
    private lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_recycle_view_main)
    }
}