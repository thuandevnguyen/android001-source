package com.example.demobuoi4

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class HelloBoundService : Service() {
  private val binder = LocalBinder()

  override fun onBind(intent: Intent?): IBinder? {
    Log.d(TAG, "$this :: onBind 1 $intent")
    return binder
  }

  override fun onUnbind(intent: Intent?): Boolean {
    Log.d(TAG, "$this :: onUnbind 2 $intent")
    return true
  }

  override fun onRebind(intent: Intent?) {
    super.onRebind(intent)
    Log.d(TAG, "$this :: onRebind 3 $intent")
  }

  inner class LocalBinder: Binder() {
    fun getHelloBoundService() = this@HelloBoundService
  }

  fun getData(): String {
    return "Demo"
  }

  companion object {
    const val TAG = "HelloBoundService"
  }
}