package com.example.demobuoi8.interceptors

import android.os.Build
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class CustomHeaderInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    Log.d("Interceptor", "--> CustomHeaderInterceptor start...")

    val request = chain.request() // get original request

    val newRequest = request.newBuilder()
      .header(
        name = "User-Agent",
        value = "Android/${Build.VERSION.SDK_INT}"
      )
      .header(
        name = "API-KEY",
        value = "abc"
      )
      .build()

    val response = chain.proceed(newRequest)
    Log.d("Interceptor", "<-- CustomHeaderInterceptor done")
    return response
  }
}