package com.example.taskandroid.task_di

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import com.example.taskandroid.task_di.di.MobileApplication
import com.example.taskandroid.task_di.di.PersonClassBinds
import com.example.taskandroid.task_di.di.PersonClassProvides
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TaskDIMain : AppCompatActivity() {
    @Inject
    lateinit var mobileApp: MobileApplication
    @Inject
    lateinit var personClassBinds: PersonClassBinds
    @Inject
    lateinit var personClassProvides: PersonClassProvides
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_dimain)
        //Mobile Application Class
        mobileApp.mobileAppl()
        //For Interface
        //PersonClass Class
        personClassBinds.educationImpl()
        personClassBinds.jobImpl()
        //For Object
        personClassProvides.educationImpl()
        personClassProvides.jobImpl()
    }
}

//Annotation
/*
@HiltAndroidApp
@AndroidEntryPoint
@Inject
@Binds
@Provides
@Singleton
@Module
*/