package com.rxmobileteam.lecture9sample.extensions

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData

@MainThread
inline fun <T : Any> MutableLiveData<T>.update(transform: (T) -> T): T {
  check(isInitialized)
  val current = this.value as T

  val updated = transform(current)
  this.value = updated

  return updated
}