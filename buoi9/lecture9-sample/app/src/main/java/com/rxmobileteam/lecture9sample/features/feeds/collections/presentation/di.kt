package com.rxmobileteam.lecture9sample.features.feeds.collections.presentation

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

@JvmField
val collectionPresentationModule = module {
  viewModelOf(::CollectionsViewModel)
}