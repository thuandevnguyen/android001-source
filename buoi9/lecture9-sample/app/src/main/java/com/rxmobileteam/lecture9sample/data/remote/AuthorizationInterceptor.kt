package com.rxmobileteam.lecture9sample.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(private val clientId: String) : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response = chain
    .request()
    .newBuilder()
    .addHeader("Authorization", "Client-ID $clientId")
    .build()
    .let(chain::proceed)
}