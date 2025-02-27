package com.example.taskandroid.task_notification_fcm

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.taskandroid.R

//Above the OREO version chanelId required
const val CHANNEL_ID = "channel_id"

class TaskNotificationFCMMain : AppCompatActivity() {
    private lateinit var scheduleNoti: Button

    //permission for notification
    val permissionArr = arrayOf(android.Manifest.permission.POST_NOTIFICATIONS)

    //for alram manager
    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_notification_fcm_main)
        //find id
        scheduleNoti = findViewById(R.id.scheduleNotificationD)

        //check permission
        if (checkSelfPermission(permissionArr[0]) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissionArr, 100)
        }

        // Register the channel with the system.
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val nfc = NotificationChannel(
            CHANNEL_ID,
            "This is a channel",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationManager.createNotificationChannel(nfc)

        //Schedule Notification
        scheduleNoti.setOnClickListener {
            val trgrTime = System.currentTimeMillis() + 3 * 1000
            Toast.makeText(this, "Schedule Notification Sent", Toast.LENGTH_SHORT).show()
            scheduleNotification(trgrTime)
        }
    }

    private fun scheduleNotification(trgrTime: Long) {
        alarmMgr = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(context, NotificationReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        }
        alarmMgr!!.set(AlarmManager.RTC_WAKEUP, trgrTime, alarmIntent)
    }
}


//code for to create channel
//val channel=NotificationChannel(CHANNEL_ID,"Simple Notification",NotificationManager.IMPORTANCE_DEFAULT)
//notificationManager.createNotificationChannel(channel)
