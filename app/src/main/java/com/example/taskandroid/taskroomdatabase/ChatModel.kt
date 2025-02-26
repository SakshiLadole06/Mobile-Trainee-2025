package com.example.taskandroid.taskroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="msg_table")
data class ChatModel(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val message : String?,
    val time : String,
    val isChecked:Boolean

)




