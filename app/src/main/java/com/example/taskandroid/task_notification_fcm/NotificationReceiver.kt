package com.example.taskandroid.task_notification_fcm

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.taskandroid.MainActivity
import com.example.taskandroid.R

class NotificationReceiver : BroadcastReceiver() {
//    val CHANNEL_ID = "notification_channel"
    val context = this

    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent) {
        // Show notification when the alarm triggers
        showNotification(context, "Reminder", "This is a repeating notification!")

        // Repeat the notification every minute
        scheduleNotification(context)
    }

    private fun showNotification(context: Context, title: String, message: String) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationId = System.currentTimeMillis().toInt()  // every time new id
        notificationManager.notify(notificationId, notification)
    }

    fun scheduleNotification(context: Context) {
        val timeperiod = 60 * 1000
        val triggerTime = System.currentTimeMillis() + timeperiod

        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, NotificationReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        }

        alarmMgr.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, alarmIntent)
    }
}