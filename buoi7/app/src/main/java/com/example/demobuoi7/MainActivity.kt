package com.example.demobuoi7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.demobuoi7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.buttonCounter.setOnClickListener {
//            viewModel.loginDemo()
//        }
        loginChange()
    }

    private fun loginChange() {
        viewModel.loginUiState.observe(this) { loginState ->
            when (loginState) {
                is LoginUiState.Error -> {
                    Toast.makeText(this, loginState.messageError, Toast.LENGTH_LONG).show()
                }

                LoginUiState.Loading -> {
                    Toast.makeText(this, "Loading State", Toast.LENGTH_LONG).show()
                }

                is LoginUiState.Success -> {
                    Toast.makeText(this, loginState.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setCount() {
        binding.textViewCount.text = viewModel.count.toString()
    }
}