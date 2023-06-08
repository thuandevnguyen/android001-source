package com.example.demobuoi8.model

import com.google.gson.annotations.SerializedName

data class TodoResponse(
    @SerializedName("userId")
    val idUser: Long,
    @SerializedName("id")
    val idTodo: Long,

    val title: String,

    val completed: Boolean
)
