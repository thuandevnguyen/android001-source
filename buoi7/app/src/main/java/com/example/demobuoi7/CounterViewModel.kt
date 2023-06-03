package com.example.demobuoi7

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class CounterViewModel(private val context: Application) : AndroidViewModel(context) {
    var count = 0

    private val _loginUiState: MutableLiveData<LoginUiState> = MutableLiveData(LoginUiState.Loading)
    val loginUiState: LiveData<LoginUiState> get() = _loginUiState

    private val _counter: MutableLiveData<Int> = MutableLiveData()
    val counter: LiveData<Int> get() = _counter

    fun counter() {
        val currentValue = _counter.value ?: 0
        _counter.value = currentValue + 1
    }

    fun loginDemo() {
        viewModelScope.launch {
            _loginUiState.value = LoginUiState.Loading
            try {
                delay(2000)
                _loginUiState.value = LoginUiState.Success("Login_Success")
            } catch (e: Exception) {
                _loginUiState.value = LoginUiState.Error("Login_Failed")
            }
        }
    }


}