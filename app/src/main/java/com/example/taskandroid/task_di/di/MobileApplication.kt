package com.example.taskandroid.task_di.di

import android.util.Log
import javax.inject.Inject

class MobileApplication @Inject constructor(val androidApp: AndroidApp,val iosApp: IosApp){
    fun mobileAppl(){
        androidApp.androidAppl()
        iosApp.iosAppl()
        Log.d("DI","Mobile Application function is calling....")
    }
}
class AndroidApp @Inject constructor(){
    fun androidAppl(){
        Log.d("DI","Android Mobile Application function is calling....")
    }
}
class IosApp @Inject constructor(){
    fun iosAppl(){
        Log.d("DI","Ios Mobile Application function is calling....")
    }
}