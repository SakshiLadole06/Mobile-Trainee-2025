package com.example.taskandroid.taskrecycleview

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R
import java.time.LocalTime

class TaskRecycleViewMain : AppCompatActivity() {
    private lateinit var recycleView: RecyclerView
    private lateinit var checkBoxForRecycleView: CheckBox
    private lateinit var editTextForRecycleView: EditText
    private lateinit var chatAdapter: TaskRecycleViewAdapter
    private lateinit var sendMsgBtn: Button
    private var chatList = mutableListOf<DataClassRecycleView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_recycle_view_main)

        //Find id of required Elements
        recycleView=findViewById(R.id.recycleView)
        sendMsgBtn=findViewById(R.id.sendMsgBtn)
        editTextForRecycleView = findViewById(R.id.editTextForRecycleView)
        checkBoxForRecycleView=findViewById(R.id.checkBoxForRecycleView)

        //setting of the layout for RecyclerView
        recycleView.layoutManager = LinearLayoutManager(this)

        //setting adapter
        chatAdapter = TaskRecycleViewAdapter(chatList, object : TaskRecycleViewAdapter.OptionsMenuClickListener {
            override fun onOptionsMenuClicked(position: Int, view: View) {
                performOptionsMenuClick(position, view)
            }
        })
        recycleView.adapter= chatAdapter

        //When click on Send Button
        sendMsgBtn.setOnClickListener{
            val message = editTextForRecycleView.text.toString().trim()
            val time = LocalTime.now().toString()
            chatAdapter.addName(message,time,checkBoxForRecycleView.isChecked)
            editTextForRecycleView.text.clear()
        }
    }

    //Implement the performOptionsMenuClick()
    private fun performOptionsMenuClick(position: Int,view:View) {
        val popupMenu = PopupMenu(this,view)
        popupMenu.inflate(R.menu.menu_recycleview)
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.action_delete -> {
                        chatList.remove(chatList[position])
                        chatAdapter.notifyDataSetChanged()
                        return true
                    }
                    R.id.action_edit -> {
                        editTextForRecycleView.setText(chatList[position].message)
                        sendMsgBtn.setOnClickListener {
                            chatList[position] = DataClassRecycleView(
                                editTextForRecycleView.text.toString().trim(),
                                LocalTime.now().toString(),
                                checkBoxForRecycleView.isChecked
                            )
                            chatAdapter.notifyItemChanged(position)
                            editTextForRecycleView.text.clear()
                        }
                        true
                    }
                }
                popupMenu.dismiss()
                return false
            }
        })
        popupMenu.show()
    }
}