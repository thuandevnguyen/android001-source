package com.example.demobuoi8.interceptors

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

class JwtTokenManager(
  private val prefs: SharedPreferences,
) {
  suspend fun read(): String? = withContext(Dispatchers.IO) {
    prefs.getString(KEY, null)
  }

  suspend fun clear() {
    withContext(Dispatchers.IO) {
      prefs.edit(commit = true) {
        remove(KEY)
      }
    }
  }

  private companion object {
    private const val KEY = "jwt"
  }
}

class AuthInterceptor(
  private val jwtTokenManager: JwtTokenManager,
) : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    Log.d("Interceptor", "--> AuthInterceptor start...")

    val request = chain.request() // get original request

    val jwtToken = runBlocking { jwtTokenManager.read() }

    val newRequest = request.newBuilder()
      .header(
        name = "Authorization",
        value = "Bearer $jwtToken"
      )
      .build()

    val response = chain.proceed(newRequest)

    if (response.code == HTTP_UNAUTHORIZED) {
      runBlocking { jwtTokenManager.clear() }
    }

    Log.d("Interceptor", "<-- AuthInterceptor done")
    return response
  }
}