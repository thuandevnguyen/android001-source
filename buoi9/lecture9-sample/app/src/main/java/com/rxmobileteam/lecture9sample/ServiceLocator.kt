package com.rxmobileteam.lecture9sample

import com.rxmobileteam.lecture9sample.data.remote.AuthorizationInterceptor
import com.rxmobileteam.lecture9sample.data.remote.UnsplashApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ServiceLocator {
  const val UNSPLASH_BASE_URL = "https://api.unsplash.com/"

  private val moshi by lazy {
    Moshi.Builder()
      .addLast(KotlinJsonAdapterFactory())
      .build()
  }

  private val httpLoggingInterceptor
    get() = HttpLoggingInterceptor().apply {
      level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
      } else {
        HttpLoggingInterceptor.Level.NONE
      }
    }

  private val authorizationInterceptor
    get() = AuthorizationInterceptor("EbwKAE7hfLK0BeLM0-_pF-nEBy6s7B8u19HUzQSZUNU")

  val okHttpClient by lazy {
    OkHttpClient.Builder()
      .connectTimeout(30, TimeUnit.SECONDS)
      .readTimeout(30, TimeUnit.SECONDS)
      .writeTimeout(30, TimeUnit.SECONDS)
      .addNetworkInterceptor(httpLoggingInterceptor)
      .addInterceptor(authorizationInterceptor)
      .build()
  }

  private val retrofit: Retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(UNSPLASH_BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(MoshiConverterFactory.create(moshi))
      .build()
  }

  val unsplashApiService: UnsplashApiService by lazy {
    UnsplashApiService(retrofit)
  }
}