package com.example.demobuoi8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.demobuoi8.databinding.ActivityMainBinding
import com.example.demobuoi8.model.PostModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<DemoRetrofitViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonCallApi.setOnClickListener {
            viewModel.getListPost()
        }
        observerDataTodo()
    }

    private fun observerDataTodo() {
        viewModel.liveDataTodo.observe(this) {
            when (it) {
                is TodoUiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is TodoUiState.SuccessTodo -> {

                }

                is TodoUiState.Failure -> {

                }

                is TodoUiState.SuccessTodoPost -> {
                    binding.progressBar.visibility = View.GONE
                    binding.textView.text = it.todo.toString()
                }

                is TodoUiState.SuccessTodoPostApi -> {
                    binding.progressBar.visibility = View.GONE
                    binding.textView.text = it.todo.first().toString()
                }
            }
        }
    }
}