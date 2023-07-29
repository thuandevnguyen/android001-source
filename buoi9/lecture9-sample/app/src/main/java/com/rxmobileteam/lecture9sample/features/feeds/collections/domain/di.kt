package com.rxmobileteam.lecture9sample.features.feeds.collections.domain

import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.usecase.GetSplashCollectionUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

@JvmField
val collectionDomainModule = module {
  factoryOf(::GetSplashCollectionUseCase)
}