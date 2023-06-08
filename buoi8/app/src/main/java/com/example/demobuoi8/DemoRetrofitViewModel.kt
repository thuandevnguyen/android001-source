package com.example.demobuoi8

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.demobuoi8.model.PostModel
import com.example.demobuoi8.model.TodoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemoRetrofitViewModel(application: Application) : AndroidViewModel(application) {
    private val mockApi = getApplication<Application>().mockApi()

    private val _liveDataTodo: MutableLiveData<TodoUiState> = MutableLiveData()
    val liveDataTodo get() = _liveDataTodo

    private var getApiTodoExample: Call<TodoResponse>? = null


    fun postApi(request: PostModel) {
        viewModelScope.launch {
            _liveDataTodo.value = TodoUiState.Loading
            try {
                val result = mockApi.postApi(request)
                _liveDataTodo.postValue(TodoUiState.SuccessTodoPost(result))
            } catch (e: Exception) {
                _liveDataTodo.value = TodoUiState.Failure(e.message ?: "Network Request failed")
            }
        }
    }
    fun getListPost() {
        viewModelScope.launch {
            _liveDataTodo.value = TodoUiState.Loading
            try {
                val result = mockApi.getListTodo()
                _liveDataTodo.postValue(TodoUiState.SuccessTodoPostApi(result))
            } catch (e: Exception) {
                _liveDataTodo.value = TodoUiState.Failure(e.message ?: "Network Request failed")
            }
        }
    }
    fun getTodoSuspend() {
        viewModelScope.launch {
            _liveDataTodo.value = TodoUiState.Loading
            try {
                val result = mockApi.getTodoSuspendExample()
                _liveDataTodo.postValue(TodoUiState.SuccessTodo(result))
            } catch (e: Exception) {
                _liveDataTodo.value = TodoUiState.Failure(e.message ?: "Network Request failed")
            }
        }
    }

    fun callApiGetTodo() {
        viewModelScope.launch(Dispatchers.IO) {
            getApiTodoExample = mockApi.getTodoExample()
            val response = getApiTodoExample?.execute()
            _liveDataTodo.postValue(TodoUiState.SuccessTodo(response?.body()!!))
        }
    }

    private fun callBackApiTodo() = object : Callback<TodoResponse> {
        override fun onResponse(call: Call<TodoResponse>, response: Response<TodoResponse>) {
            if (response.isSuccessful && response.body() != null) {
                _liveDataTodo.value = TodoUiState.SuccessTodo(response.body()!!)
            } else {
                _liveDataTodo.value = TodoUiState.Failure("Network Request failed")
            }
        }

        override fun onFailure(call: Call<TodoResponse>, t: Throwable) {
            _liveDataTodo.value = TodoUiState.Failure("Network Request failed")
        }
    }
}
