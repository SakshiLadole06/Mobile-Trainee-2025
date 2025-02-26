package com.example.taskandroid.taskroomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DataDao {
    @Insert
    fun insertData(data : ChatModel)

    @Update
    fun updateData(data : ChatModel)

    @Delete
    fun deleteData(data : ChatModel)

    @Query("SELECT* FROM MSG_TABLE")
    fun getAllData():List<ChatModel>
}

