package com.example.taskandroid.taskroomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ChatModel::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun dataDao(): DataDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Chat Data"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}