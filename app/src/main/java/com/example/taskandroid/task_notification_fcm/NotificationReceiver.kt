package com.example.taskandroid.task_notification_fcm

import android.Manifest
import android.annotation.SuppressLint
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
    override fun onReceive(context: Context, intent: Intent?) {
        val mainAcitivityIntent = Intent(context, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(context, 100, mainAcitivityIntent, PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Scheduled Notification")
            .setContentText("This notification was scheduled.")
//            .setLargeIcon(
//                BitmapFactory.decodeResource(
//                    context.resources,
//                    R.drawable.android_studio
//                )
//            )
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Schedule Notification",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationManager.createNotificationChannel(channel)
        notificationManager.notify(100, builder.build())
    }
}
