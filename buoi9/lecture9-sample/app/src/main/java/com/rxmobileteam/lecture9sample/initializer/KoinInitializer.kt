package com.rxmobileteam.lecture9sample.initializer

import android.content.Context
import androidx.startup.Initializer
import com.rxmobileteam.lecture9sample.di.networkModule
import com.rxmobileteam.lecture9sample.di.repositoryModule
import com.rxmobileteam.lecture9sample.di.sharePrefModule
import com.rxmobileteam.lecture9sample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class KoinInitializer : Initializer<KoinApplication> {
  override fun create(context: Context): KoinApplication = startKoin {

    Timber.tag("KoinInitializer").d("Koin initialized")

    androidLogger(Level.ERROR)
    androidContext(context)
    modules(
      listOf(
        networkModule,
        repositoryModule,
        viewModelModule,
        sharePrefModule
      )
    )
  }

  override fun dependencies(): List<Class<out Initializer<*>>> =
    listOf(TimberInitializer::class.java)
}