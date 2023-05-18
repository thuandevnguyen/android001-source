package com.example.demobuoi4

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import android.os.Parcelable
import android.util.Log
import androidx.core.app.NotificationCompat

//sealed interface HelloAction : Parcelable {
//  data class PlayMusic(val uri: Uri): HelloAction
//  data class StopMusic(val uri: Uri): HelloAction
//  object ClearPlaylist: HelloAction
//}

class HelloForegroundService : Service() {

  override fun onBind(intent: Intent?): IBinder? {
    return null
  }

  override fun onCreate() {
    super.onCreate()
    Log.d(TAG, "$this :: onCreate")
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    val actionString = intent?.getStringExtra(EXTRA_ACTION_KEY)

//    when(val action = intent?.getParcelableExtra<HelloAction>("HelloAction")) {
//      is HelloAction.PlayMusic -> {
//        action.uri
//      }
//      is HelloAction.StopMusic ->{
//        action.uri
//      }
//      null -> TODO()
//      HelloAction.ClearPlaylist -> TODO()
//    }

    when(actionString) {
      "START" -> {

      }
      "STOP" -> {

      }
    }

    Log.d(TAG, "$this :: onStartCommand intent=$intent -> actionString=$actionString")

    val builder = NotificationCompat
      .Builder(this, getString(R.string.notification_channel_id))
      .setSmallIcon(R.mipmap.ic_launcher)
      .setContentTitle("Service $this is running...")
      .setContentText("...")
      .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notification = builder.build()

    startForeground(
      NOTIFICATION_ID,
      notification,
    )

    return START_NOT_STICKY
  }

  override fun onDestroy() {
    Log.d(TAG, "$this :: onDestroy")
    super.onDestroy()
  }

  companion object {
    private const val TAG = "HelloForegroundService"
    private const val NOTIFICATION_ID = 111
    const val EXTRA_ACTION_KEY = "EXTRA_ACTION_KEY"
  }
}