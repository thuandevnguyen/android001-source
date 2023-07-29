package com.rxmobileteam.lecture9sample.features.feeds.collections.domain.usecase

import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.entity.UnsplashCollection
import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.repository.UnsplashCollectionRepository

class GetSplashCollectionUseCase(
  private val splashCollectionRepository: UnsplashCollectionRepository,
) {
  suspend operator fun invoke(
    page: Int,
    perPage: Int,
  ): List<UnsplashCollection> = splashCollectionRepository.getCollections(page, perPage)
}