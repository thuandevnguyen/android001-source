package com.rxmobileteam.lecture9sample.work

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach

class DownloadWorker(appContext: Context, params: WorkerParameters) :
  CoroutineWorker(appContext, params) {
  override suspend fun doWork(): Result {
    val fileUrl = checkNotNull(inputData.getString(KEY_FILE_URL)) {
      "FILE_URL is null"
    }

    Log.d(TAG, "doWork: start $fileUrl")

    (0..100).asFlow()
      .onEach { delay(1000) }
      .collect {
        setProgress(workDataOf("progress" to it))
        Log.d(TAG, "doWork: progress $fileUrl $it")
      }

    Log.d(TAG, "doWork: end $fileUrl")
    return Result.success(
      workDataOf(
        "fileUrl" to fileUrl,
        "localFileUri" to "success"
      )
    )
  }

  companion object {
    const val TAG = "DownloadWorker"
    const val KEY_FILE_URL = "FILE_URL"
  }
}