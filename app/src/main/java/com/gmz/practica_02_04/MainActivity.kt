package com.gmz.practica_02_04

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    val btNotificacion: Button by lazy {
        findViewById(R.id.btNotificacion)
    }
    private var notificationManager:NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val notificationId = 1
        val channelId = "my_channel_01"

        val viewPendingIntent = Intent(this, DetailActivity2::class.java)
            .let { viewIntent ->
                viewIntent.putExtra("detalle","Detalle de la notificación")
                PendingIntent.getActivity(this, 0, viewIntent,0)
            }

        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(channelId, "Channel_Practica_04", importance)
        notificationManager?.createNotificationChannel(channel)

        val notificationBuilder = NotificationCompat.Builder( this, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Practica 04")
            .setContentText("Contenido de la notificación")
            .setContentIntent(viewPendingIntent)

        btNotificacion.setOnClickListener{
            NotificationManagerCompat.from(this).apply{
                notify(notificationId, notificationBuilder.build())
            }
        }
    }


}

