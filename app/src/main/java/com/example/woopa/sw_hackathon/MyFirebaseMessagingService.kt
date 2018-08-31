package com.example.woopa.sw_hackathon

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {


    companion object {
        val TAG = "MyFirebseMsgService"
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG,"From : " + remoteMessage!!.from)
        
        
        if(remoteMessage?.data.size > 0){
            Log.d(TAG, "Message data payload : " + remoteMessage?.data)
        }
        
        if(remoteMessage?.notification != null) {
            Log.d(TAG,"Message Notification Body : " + remoteMessage?.notification?.body)
            sendNotification(remoteMessage!!.notification?.body)
        }
    }

    private fun sendNotification(messageBody : String?) {
        val intent = Intent(this@MyFirebaseMessagingService,MainActivity::class.java)
                .apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) }

       var pendingIntent = PendingIntent.getActivity(this@MyFirebaseMessagingService,0,intent,
                PendingIntent.FLAG_ONE_SHOT)

        var channelID = getString(R.string.default_web_client_id);
        var defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        var notificationBuilder = NotificationCompat.Builder(this@MyFirebaseMessagingService,channelID)
                .apply { setSmallIcon(R.mipmap.ic_launcher)
                        setContentTitle("")
                        setContentText(messageBody)
                        setAutoCancel(true)
                        setSound(defaultSoundUri)
                        setContentIntent(pendingIntent)}

        var notificationManager =
                getSystemService((Context.NOTIFICATION_SERVICE)) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            var channelName = getString(R.string.default_web_client_id)
            var channel = NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0,notificationBuilder.build())

    }
}