package com.rxmobileteam.lecture9sample.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.rxmobileteam.lecture9sample.utils.ConsoleLoggerImpl
import com.rxmobileteam.lecture9sample.utils.FileSystemLoggerImpl
import com.rxmobileteam.lecture9sample.utils.Logger
import com.rxmobileteam.lecture9sample.utils.MySharePref
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sharePrefModule = module {
  single { androidContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE) }

//  factory { MySharePref(get()) }


  single<Logger>(named("LoggerConsole")) { ConsoleLoggerImpl() }
  single<Logger>(named("LoggerFileSystem")) { FileSystemLoggerImpl() }

  single<DataStore<Preferences>> {
    PreferenceDataStoreFactory.create {
      androidApplication().preferencesDataStoreFile("settings")
    }
  }
}