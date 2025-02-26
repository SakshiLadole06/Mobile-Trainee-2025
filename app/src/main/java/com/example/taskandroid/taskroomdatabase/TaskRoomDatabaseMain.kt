package com.example.taskandroid.taskroomdatabase

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

class TaskRoomDatabaseMain : AppCompatActivity() {
    private lateinit var recycleView: RecyclerView
    private lateinit var checkBoxForRecycleView: CheckBox
    private lateinit var editTextForRecycleView: EditText
    private lateinit var chatAdapter: RoomDataAdapter
    private lateinit var sendMsgBtn: Button
    private var chatList = mutableListOf<ChatModel>()

    //for calling either insert or update
    var updatingChatIndex = -1

    //Room Database
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_room_database_main)
        //Find id of required Elements
        recycleView = findViewById(R.id.roomRecycleView)
        sendMsgBtn = findViewById(R.id.sendMsgBtnRoom)
        editTextForRecycleView = findViewById(R.id.editTextForRoom)
        checkBoxForRecycleView = findViewById(R.id.checkBoxForRoom)

        // Initialize database
        database = AppDatabase.getDatabase(this)

        //setting of the layout for RecyclerView
        recycleView.layoutManager = LinearLayoutManager(this)

        //setting adapter
        chatAdapter = RoomDataAdapter(
            chatList,
            object : RoomDataAdapter.OptionsMenuClickListener {
                override fun onOptionsMenuClicked(position: Int, view: View) {
                    performOptionsMenuClick(position, view)
                }
            })

        recycleView.adapter = chatAdapter

        //When click on Send Button
        sendMsgBtn.setOnClickListener {
            if (updatingChatIndex != -1) {
                // updating
                val newMsg = editTextForRecycleView.text.toString().trim()
                if (newMsg.isEmpty()) return@setOnClickListener // Prevent empty updates
                val newTime = LocalTime.now().toString()
                val newChecked = checkBoxForRecycleView.isChecked
                // Create updated item
                val updatedItem = ChatModel(
                    chatList[updatingChatIndex].id,
                    newMsg,
                    newTime,
                    newChecked
                )
                updateData(updatedItem)
            } else {
                //adding
                val message = editTextForRecycleView.text.toString().trim()
                val time = LocalTime.now().toString()
                insertData(message, time)
                editTextForRecycleView.text.clear()
            }
        }

        //user defined function for load data in database
        loadAllDataInDB()
    }

    //Implement the performOptionsMenuClick()
    private fun performOptionsMenuClick(position: Int, view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_recycleview)
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.action_delete -> {
                        deleteChat(position)
                        return true
                    }

                    R.id.action_edit -> {
                        updatingChatIndex = position
                        val chat = chatList[position] // Get the current item

                        // Set EditText with the current message for editing
                        editTextForRecycleView.setText(chat.message)
                        checkBoxForRecycleView.isChecked = chat.isChecked
                        return true
                    }
                }
                popupMenu.dismiss()
                return false
            }
        })
        popupMenu.show()
    }

    //To insert the data in database
    private fun insertData(msg: String?, time: String) {
        if (msg.isNullOrEmpty()) return // Prevent inserting empty messages
        database.dataDao()
            .insertData(ChatModel(0, msg, time, checkBoxForRecycleView.isChecked))
        chatList.add(ChatModel(0, msg, time, checkBoxForRecycleView.isChecked))
        chatAdapter.notifyItemInserted(chatList.size - 1)
    }

    //To update the data in database
    private fun updateData(updatedChat: ChatModel) {
        // Update database
        database.dataDao().updateData(updatedChat)
        // Update only that specific item in the list using set()
        chatList[updatingChatIndex] = updatedChat
        // Notify RecyclerView about the item change
        chatAdapter.notifyItemChanged(updatingChatIndex)
        // Clear EditText after update
        editTextForRecycleView.text.clear()
        updatingChatIndex = -1
    }

    //To delete the data in data base
    private fun deleteChat(position: Int) {
        // Get the item to delete
        val item = chatList[position]
        // Delete from database
        chatList.removeAt(position)
        database.dataDao().deleteData(item)
        // Remove from list and notify adapter
        chatAdapter.notifyItemRemoved(position)
//        chatAdapter.notifyItemRangeChanged(position,chatList.size-1)
    }

    private fun loadAllDataInDB() {
        val dataFromDB = database.dataDao().getAllData()
        chatList.clear()
        chatList.addAll(dataFromDB)
        chatAdapter.notifyDataSetChanged()
    }
}

//Annotation
/*
@Dao
@Entity
@PrimaryKey
@Insert
@Query
@volatile
@database
@delete
@update
*/
