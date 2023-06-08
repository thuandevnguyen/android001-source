package com.example.demobuoi8

import com.example.demobuoi8.model.PostModel
import com.example.demobuoi8.model.PostResponse
import com.example.demobuoi8.model.TodoResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


fun mockApi(): MockApi = createMockApi()

interface MockApi {
    @GET("/todos/1")
    fun getTodoExample(): Call<TodoResponse>

    @GET("/todos/1")
    suspend fun getTodoSuspendExample(): TodoResponse

    @POST("/posts")
    suspend fun postApi(@Body request : PostModel) : PostModel

    @GET("/posts")
    suspend fun getListTodo(): List<PostResponse>
}

fun createMockApi(): MockApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(MockApi::class.java)
}