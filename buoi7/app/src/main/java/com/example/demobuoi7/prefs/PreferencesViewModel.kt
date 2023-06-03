package com.example.demobuoi7.prefs

import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.preference.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class PreferencesViewModel(application: Application) : AndroidViewModel(application) {
  private val prefs = PreferenceManager.getDefaultSharedPreferences(application)
  private val listener = object : SharedPreferences.OnSharedPreferenceChangeListener {
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
      _allData.value = sharedPreferences?.all ?: emptyMap()
    }
  }

  private val _allData = MutableLiveData(mapOf<String, Any?>())
  val allData: LiveData<Map<String, Any?>> get() = _allData

  init {
    prefs.registerOnSharedPreferenceChangeListener(listener)
  }

  override fun onCleared() {
    prefs.unregisterOnSharedPreferenceChangeListener(listener)
    super.onCleared()
  }

  fun updateData() {
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        prefs.edit(commit = true) {
          putInt("my_age", Random.nextInt(100))
          putBoolean("is_logged_in", Random.nextBoolean())
          putStringSet("history", setOf("1", "2", "3"))
        }
      }
    }
  }
}