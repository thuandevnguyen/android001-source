package com.example.demobuoi8

import com.example.demobuoi8.model.PostModel
import com.example.demobuoi8.model.PostResponse
import com.example.demobuoi8.model.TodoResponse

sealed class TodoUiState {
    object Loading : TodoUiState()
    data class SuccessTodo(val todo: TodoResponse) : TodoUiState()
    data class SuccessTodoPost(val todo: PostModel) : TodoUiState()
    data class SuccessTodoPostApi(val todo: List<PostResponse>) : TodoUiState()
    data class Failure(val error: String) : TodoUiState()
}
