package com.rxmobileteam.lecture9sample.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DataStoreDemoViewModel(
  private val preferencesDataStore: DataStore<Preferences>
) : ViewModel() {
  val counterStateFlow: StateFlow<Int> = preferencesDataStore.data
    .map { it[COUNTER_KEY] ?: 0 }
    .stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
      initialValue = 0
    )

  val darkThemeStateFlow = preferencesDataStore.data
    .map { it[DARK_THEME_KEY] ?: false }
    .stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
      initialValue = false
    )

  fun update() {
    viewModelScope.launch {
      preferencesDataStore.edit {
        it[COUNTER_KEY] = (it[COUNTER_KEY] ?: 0) + 1
        it[DARK_THEME_KEY] = !(it[DARK_THEME_KEY] ?: false)
      }
    }
  }

  fun remove() {
    viewModelScope.launch {
      preferencesDataStore.edit {
        it.remove(COUNTER_KEY)
        it.remove(DARK_THEME_KEY)
      }
    }
  }

  private companion object {
    private val COUNTER_KEY = intPreferencesKey("counter")
    private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")
  }
}