package com.rxmobileteam.lecture9sample.work

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.rxmobileteam.lecture9sample.databinding.ActivityWorkDemoBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.LazyThreadSafetyMode.NONE

class WorkDemoActivity: AppCompatActivity() {
  private val  binding by lazy(NONE) { ActivityWorkDemoBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    binding.run {
      buttonEnqueue.setOnClickListener {
        doEnqueue()
      }

      buttonCancel.setOnClickListener {
        doCancel()
      }
    }

    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        WorkManager.getInstance(this@WorkDemoActivity)
          .getWorkInfosByTagLiveData(DownloadWorker.TAG)
          .asFlow()
          .collectLatest { workInfos: List<WorkInfo>? ->
            renderWorkInfos(workInfos)
          }
      }
    }
  }

  private fun renderWorkInfos(workInfos: List<WorkInfo>?) {
    binding.textView.text = workInfos?.joinToString("\n") { workInfo ->
      "${workInfo.id}: state=${workInfo.state} -> progress=${workInfo.progress} -> outputData=${workInfo.outputData}"
    }
  }

  private fun doCancel() {
    WorkManager
      .getInstance(this)
      .cancelAllWorkByTag(DownloadWorker.TAG)
  }

  private fun doEnqueue() {
    val constraints = Constraints.Builder()
      .setRequiredNetworkType(NetworkType.CONNECTED)
      .setRequiresCharging(false)
      .setRequiresBatteryNotLow(true)
      .setRequiresStorageNotLow(true)
      .build()

    val workRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
      .setConstraints(constraints)
      .setInitialDelay(1_000, java.util.concurrent.TimeUnit.MILLISECONDS)
      .addTag(DownloadWorker.TAG)
      .setInputData(
        workDataOf(
          DownloadWorker.KEY_FILE_URL
            to "https://www.google.com"
        )
      )
      .build()

    WorkManager
      .getInstance(this)
      .enqueue(workRequest)
  }
}