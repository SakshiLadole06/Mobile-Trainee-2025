package com.example.taskandroid.taskactivity.data_pass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskandroid.R

const val REQUEST_CODE = 100
class SecondActivityGetDataAndPaasIt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_get_data_and_paas_it)

        //Button for the clicking Move to the previous page
        val sendDataBtn: Button =findViewById(R.id.sendDataBtn)
        sendDataBtn.setOnClickListener {
            val editName =findViewById<EditText>(R.id.nameEdit)
            val msgName=editName.text.toString()
            val editAge =findViewById<EditText>(R.id.ageEdit)
            val msgAge=editAge.text.toString()
            val intent = Intent(this, DataPass::class.java).also{
                it.putExtra("Name",msgName)
                it.putExtra("Age",msgAge)
                setResult(Activity.RESULT_OK, it)
                finish()
            }
        }
    }
}