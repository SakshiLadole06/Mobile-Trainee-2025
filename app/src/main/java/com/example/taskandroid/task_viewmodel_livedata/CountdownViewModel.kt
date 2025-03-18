package com.example.taskandroid.task_viewmodel_livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountdownViewModel:ViewModel() {
    private val _timer = MutableLiveData<Int>().apply { value=0 }
    val timer:LiveData<Int> get() =  _timer

    private var timerJob: Job? = null

    fun startTimer(countDown:Int){
        timerJob?.cancel()
        var temp=countDown
        timerJob=viewModelScope.launch(Dispatchers.IO) {
            while(temp>=0){
                withContext(Dispatchers.Main) {
                    _timer.value=temp
                }
                temp--
                Log.d("ABC","$temp")
                delay(1000)
            }
        }
    }

    fun stopTimer() {
        _timer.value = 0
        timerJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}