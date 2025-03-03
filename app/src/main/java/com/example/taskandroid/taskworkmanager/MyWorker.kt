package com.example.taskandroid.taskworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.Data

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        for (count in 0..10) {
            Log.d("My Worker", "$count")
            Thread.sleep(1000)
        }
        return Result.success()
    }
}
