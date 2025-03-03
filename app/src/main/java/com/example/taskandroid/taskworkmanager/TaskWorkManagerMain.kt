package com.example.taskandroid.taskworkmanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.taskandroid.R

class TaskWorkManagerMain : AppCompatActivity() {
    private lateinit var OneTimeWork:Button
    private lateinit var PeriodicTimeWork:Button
    private lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_work_manager_main)
        //find ids
        OneTimeWork=findViewById(R.id.OneTimeWork)
        PeriodicTimeWork=findViewById(R.id.PeriodicTimeWork)
        tv=findViewById(R.id.tvWork)

        OneTimeWork.setOnClickListener{
            tv.text = ""
            OneTimeWorkFun()
        }

        PeriodicTimeWork.setOnClickListener{
            tv.text = ""
            ConstraintsWorkFun()
        }
    }
    fun OneTimeWorkFun(){
        val myWorkRequest:WorkRequest=OneTimeWorkRequest.Builder(MyWorker::class.java)
            .addTag("OneTimeWork")
            .build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)

        // Observe the work status
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id)
            .observe(this, Observer { workInfo ->
                tv.text=workInfo?.state.toString()
//                if (workInfo != null && workInfo.state.isFinished) {
//                    tv.text = "Work Completed"
//                }one of the way
            })
    }

    fun ConstraintsWorkFun(){
        val constraints=Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .build()
        val myWorkRequest:WorkRequest=OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setConstraints(constraints)
            .addTag("ConstraintsWorkFun")
            .build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)
        // Observe the work status
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(myWorkRequest.id)
            .observe(this, Observer { workInfo ->
                    tv.text = workInfo?.state.toString()
            })
    }
}