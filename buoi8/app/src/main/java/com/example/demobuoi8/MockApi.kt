package com.example.demobuoi8

import android.content.Context
import com.example.demobuoi8.interceptors.AuthInterceptor
import com.example.demobuoi8.interceptors.CustomHeaderInterceptor
import com.example.demobuoi8.interceptors.JwtTokenManager
import com.example.demobuoi8.model.PostModel
import com.example.demobuoi8.model.PostResponse
import com.example.demobuoi8.model.TodoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


fun Context.mockApi(): MockApi = createMockApi()

interface MockApi {
    @GET("/todos/1")
    fun getTodoExample(): Call<TodoResponse>

    @GET("/todos/1")
    suspend fun getTodoSuspendExample(): TodoResponse

    @POST("/posts")
    suspend fun postApi(@Body request: PostModel): PostModel

    @GET("/posts")
    suspend fun getListTodo(): List<PostResponse>
}

fun Context.provideJwtTokenManager(): JwtTokenManager {
    return JwtTokenManager(
        getSharedPreferences(
            "jwt_prefs",
            Context.MODE_PRIVATE
        )
    )
}

fun Context.provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
        )
        .addInterceptor(CustomHeaderInterceptor())
        .addInterceptor(AuthInterceptor(provideJwtTokenManager()))
        .build()
}

fun Context.createMockApi(): MockApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(MockApi::class.java)
}