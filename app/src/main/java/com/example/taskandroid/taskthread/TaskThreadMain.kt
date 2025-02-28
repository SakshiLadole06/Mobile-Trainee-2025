package com.example.taskandroid.taskthread

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskandroid.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TaskThreadMain : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_thread_main)
        //find ids
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        tv4 = findViewById(R.id.tv4)

        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)

        b1.setOnClickListener {
            performTask1()
        }
        b2.setOnClickListener {
            performTask2(5, 2)
        }
        b3.setOnClickListener {
            PerformTask3(tv3, this).execute()
        }
        b4.setOnClickListener {
            performTask4()
        }
    }

    private fun performTask1() {
        Thread {
            val result = 5 + 2
//            Log.d("ABC", "${Thread.currentThread().name}")  op:-Thread 3
            runOnUiThread {
                tv1.setText(result.toString())
//                Log.d("ABC", "${Thread.currentThread().name}") op:-main
            }
        }.start()
    }

    private fun performTask2(n1: Int, n2: Int) {
        val td2 = Thread {
            val result = 5 + 2
            Thread {
                val result1 = result + 6
//                Log.d("ABC", "${Thread.currentThread().name}") op:-Thread 3
                runOnUiThread {
                    tv2.text = result1.toString()
//                    Log.d("ABC", "${Thread.currentThread().name}")   op:-Thread 4
                }
            }.start()
//            Log.d("ABC", "${Thread.currentThread().name}")   op:-main
        }
        td2.start()
    }

    //Class extend Async Task
    class PerformTask3(var tv3: TextView, val context: Context) : AsyncTask<Int, Int, Int>() {
        var count = 0
        override fun onPreExecute() {
//            Log.d("ABC1", "${Thread.currentThread().name}")  op:-main
            tv3.text = "Counting..." // Simulate network delay
        }

        override fun doInBackground(vararg params: Int?): Int? {
//            Log.d("ABC2", "${Thread.currentThread().name}")  op:-AsyncTask #1
            Thread.sleep(1000)
            while (count <= 10) {
                tv3.text = count.toString()
                Thread.sleep(1000) // Simulate network delay
                count++
            }
            return 0
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Int?) {
//            Log.d("ABC4", "${Thread.currentThread().name}")  op:-main
            super.onPostExecute(result)
            Toast.makeText(context, "Execution Completed...!", Toast.LENGTH_SHORT).show()
            tv3.text = "Execution Completed..."
        }
    }

    private fun performTask4() {
//        CoroutineScope(Dispatchers.Main).launch{
//            Log.d("ABC", "${Thread.currentThread().name}")
//            withContext(IO){
//                val result=5*5/2+10*6
//                runOnUiThread {
//                    tv4.text=result.toString()
//                }
//                Log.d("ABC", "${Thread.currentThread().name}")
//            }
//        }
        CoroutineScope(IO).launch {
            val result: Int
            result = 5 * 5 / 2 + 10 * 6
//            Log.d("ABC", "${Thread.currentThread().name}")  op;-DefaultDispatcher-worker-1
            withContext(Dispatchers.Main) {
                tv4.text = result.toString()
//                Log.d("ABC", "${Thread.currentThread().name}")  op:-main
            }
        }
    }
}