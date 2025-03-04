package com.example.taskandroid.task_notification_fcm

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.app.NotificationCompat
import com.example.taskandroid.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.net.URL

class FCMService:FirebaseMessagingService(){
    private val context=this
    override fun onMessageReceived(message: RemoteMessage){
        super.onMessageReceived(message)
            if(message.notification?.imageUrl==null)
                showNotification(message.notification?.title,message.notification?.body)
            else
                showBigPictureNotification(message.notification?.title,message.notification?.body,message.notification?.imageUrl)
    }

    private fun showNotification(title: String?, msgBody: String?){
        val notificationD = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(msgBody)
            .build()

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0,notificationD)
    }

    private fun showBigPictureNotification(title: String?, msgBody: String?, imageUrl: Uri?) {
//      val bitmap = BitmapFactory.decodeResource(context.resources,R.drawable.android_studio)
        val notificationD = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(msgBody)
            .apply {
                imageUrl.let {
                    val image = BitmapFactory.decodeStream(
                        URL(it.toString()).openConnection().getInputStream()
                    )
                    setStyle(NotificationCompat.BigPictureStyle().bigPicture(image))
                }

            }
//            .setLargeIcon(BitmapFactory.decodeResource(
//                context.resources,
//                R.drawable.android_studio
//            ))
//            .setStyle(NotificationCompat.BigPictureStyle()
//                .bigPicture(bitmap))
            .build()
        //https://firebase.google.com/static/images/brand-guidelines/logo-vertical.png
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0,notificationD)
    }


}