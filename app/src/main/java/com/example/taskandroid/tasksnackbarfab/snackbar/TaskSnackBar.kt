package com.example.taskandroid.tasksnackbarfab.snackbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.taskandroid.R
import com.google.android.material.snackbar.Snackbar

class TaskSnackBar : AppCompatActivity() {
    private lateinit var snakeBarBtn1: Button
    private lateinit var snakeBarBtn2: Button
    private lateinit var snakeBarBtn3: Button
    private lateinit var snakeBarBtn4: Button
    private lateinit var snakeBarBtn5: Button
    private lateinit var snakeBarBtn6: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_snackbar)
        //First snake bar
        snakeBarBtn1 = findViewById(R.id.btnForSnakeBar1)
        snakeBarBtn1.setOnClickListener {
            Snackbar.make(/* it means name of layout where we want to show thw snackbar*/
                it,
                "Simple Snack Bar",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        //Second snake bar
        snakeBarBtn2 = findViewById(R.id.btnForSnakeBar2)
        snakeBarBtn2.setOnClickListener {
            val snakeBar= Snackbar.make(it, "Action Snack Bar", Snackbar.LENGTH_INDEFINITE)
            //For dismiss bcz of Snackbar.LENGTH_INDEFINITE
            snakeBar.setAction("close",(View.OnClickListener {
                snakeBar.dismiss()
            }))
            snakeBar.show()
        }

        //third snake bar
        snakeBarBtn3 = findViewById(R.id.btnForSnakeBar3)
        snakeBarBtn3.setOnClickListener {
            Snackbar.make(it, "Action Snack Bar", Snackbar.LENGTH_LONG)
                .setAction("Close", { view ->
                    Toast.makeText(this, "You presssed the close button!", Toast.LENGTH_LONG).show()
                }).show()
        }

        //4th snake bar
        snakeBarBtn4 = findViewById(R.id.btnForSnakeBar4)
        snakeBarBtn4.setOnClickListener {
            Snackbar.make(it, "Action Snack Bar", Snackbar.LENGTH_LONG)
                .setActionTextColor(ContextCompat.getColor(this, R.color.orange))
                .setBackgroundTint(ContextCompat.getColor(this, R.color.base))
                .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                .setAnchorView(R.id.btnForSnakeBar4)
                .setTextColor(ContextCompat.getColor(this, R.color.pink))
                .setAction("Close", { view ->
                    Toast.makeText(this, "You presssed the close button!", Toast.LENGTH_LONG).show()
                }).show()
        }

        //5th snake bar
        snakeBarBtn5 = findViewById(R.id.btnForSnakeBar5)
        snakeBarBtn5.setOnClickListener {
            Snackbar.make(it, "Action Snack Bar", Snackbar.LENGTH_LONG)
                .setActionTextColor(ContextCompat.getColor(this, R.color.blue))
                .setBackgroundTint(ContextCompat.getColor(this, R.color.base))
                .setAnimationMode(Snackbar.ANIMATION_MODE_FADE)
                .setAnchorView(R.id.btnForSnakeBar5)
                .setTextColor(ContextCompat.getColor(this, R.color.black))
                .setAction("Close", { view ->
                    Toast.makeText(this, "You presssed the close button!", Toast.LENGTH_LONG).show()
                }).show()
        }

        //6th snake bar
        snakeBarBtn6 = findViewById(R.id.btnForSnakeBar6)
        snakeBarBtn6.setOnClickListener {
            Snackbar.make(it, "Action Snack Bar", Snackbar.LENGTH_LONG)
                .setActionTextColor(ContextCompat.getColor(this, R.color.black))
                .setBackgroundTint(ContextCompat.getColor(this, R.color.white))
                .setAnchorView(R.id.btnForSnakeBar6)
                .setTextColor(ContextCompat.getColor(this, R.color.black))
                .setAction("Close", { view ->
                    Toast.makeText(this, "You presssed the close button!", Toast.LENGTH_LONG).show()
                }).show()
        }
    }
}