package com.rxmobileteam.lecture9sample

import android.app.Application
import com.rxmobileteam.lecture9sample.di.networkModule
import com.rxmobileteam.lecture9sample.di.repositoryModule
import com.rxmobileteam.lecture9sample.di.sharePrefModule
import com.rxmobileteam.lecture9sample.di.viewModelModule
import com.rxmobileteam.lecture9sample.features.feeds.collections.data.collectionDataModule
import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.collectionDomainModule
import com.rxmobileteam.lecture9sample.features.feeds.collections.presentation.collectionPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UnSplashApplication : Application()