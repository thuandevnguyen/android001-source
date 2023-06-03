package com.example.demobuoi7.room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demobuoi7.databinding.ActivityRoomBinding
import kotlin.LazyThreadSafetyMode.NONE

class DemoRoomActivity : AppCompatActivity() {
  private val binding by lazy(NONE) { ActivityRoomBinding.inflate(layoutInflater) }
  private val viewModel by viewModels<RoomViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    viewModel.userAndNotesLiveData.observe(this) { data ->
      binding.textView.text = """
      | User: ${data?.user}
      | Count: ${data?.notes?.size ?: 0}
      | Notes: ${data?.notes?.joinToString(separator = "\n")}
      """.trimMargin()
    }

    binding.button.setOnClickListener {
      viewModel.addNewData()
    }
  }
}