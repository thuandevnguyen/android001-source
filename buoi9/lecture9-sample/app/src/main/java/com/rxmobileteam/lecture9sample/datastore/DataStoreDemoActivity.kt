package com.rxmobileteam.lecture9sample.datastore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rxmobileteam.lecture9sample.databinding.ActivityDataStoreDemoBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.LazyThreadSafetyMode.NONE

class DataStoreDemoActivity : AppCompatActivity() {
  private val binding by lazy(NONE) { ActivityDataStoreDemoBinding.inflate(layoutInflater) }
  private val viewModel by viewModel<DataStoreDemoViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    lifecycleScope.launch {
      lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel
          .counterStateFlow
          .collectLatest { binding.textView.text = "Counter is $it" }
      }
    }

    lifecycleScope.launch {
      lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel
          .darkThemeStateFlow
          .collectLatest { binding.textView3.text = "Dark theme is $it" }
      }
    }

    binding.run {
      buttonUpdate.setOnClickListener {
        viewModel.update()
      }

      buttonRemove.setOnClickListener {
        viewModel.remove()
      }
    }

  }
}