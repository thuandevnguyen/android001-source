package com.example.demobuoi7.prefs

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demobuoi7.R
import com.example.demobuoi7.databinding.ActivityPrefsBinding
import kotlin.LazyThreadSafetyMode.NONE

class PrefsActivity : AppCompatActivity() {
  private val binding by lazy(NONE) { ActivityPrefsBinding.inflate(layoutInflater) }
  private val viewModel by viewModels<PreferencesViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    binding.button.setOnClickListener {
      viewModel.updateData()
    }

    viewModel.allData.observe(this) {
      binding.textView.text = it.toString()
    }
  }
}