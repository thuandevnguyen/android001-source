package com.example.demobuoi7

sealed class LoginUiState {
    object Loading : LoginUiState()
    data class Success(val message: String) : LoginUiState()
    data class Error(val messageError: String) : LoginUiState()
}