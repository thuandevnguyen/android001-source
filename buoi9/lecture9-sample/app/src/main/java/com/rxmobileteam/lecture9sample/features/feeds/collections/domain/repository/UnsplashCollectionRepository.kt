package com.rxmobileteam.lecture9sample.features.feeds.collections.domain.repository

import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.entity.UnsplashCollection

interface UnsplashCollectionRepository {
  suspend fun getCollections(
    page: Int,
    perPage: Int,
  ): List<UnsplashCollection>
}