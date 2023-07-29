package com.rxmobileteam.lecture9sample.features.feeds.collections.data

import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.repository.UnsplashCollectionRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

@JvmField
val collectionDataModule = module {
  factoryOf(::UnsplashCollectionRepositoryImpl) { bind<UnsplashCollectionRepository>() }
}