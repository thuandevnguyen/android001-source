package com.rxmobileteam.lecture9sample.features.feeds.collections.data

import com.rxmobileteam.lecture9sample.data.remote.UnsplashApiService
import com.rxmobileteam.lecture9sample.data.remote.response.CollectionListResponseItem
import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.entity.UnsplashCollection
import com.rxmobileteam.lecture9sample.features.feeds.collections.domain.repository.UnsplashCollectionRepository

class UnsplashCollectionRepositoryImpl(
  private val unsplashApiService: UnsplashApiService,
) : UnsplashCollectionRepository {
  override suspend fun getCollections(page: Int, perPage: Int) =
    unsplashApiService
      .getCollections(
        page = page,
        perPage = perPage,
      )
      .map(CollectionListResponseItem::toUnsplashCollection)
}


private fun CollectionListResponseItem.toUnsplashCollection() =
  UnsplashCollection(
    id = id,
    title = title,
    description = description.orEmpty(),
    coverUrl = coverPhoto.urls.regular,
  )
