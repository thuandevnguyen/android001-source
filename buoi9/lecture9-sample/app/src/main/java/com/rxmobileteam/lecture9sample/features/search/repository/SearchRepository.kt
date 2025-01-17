package com.rxmobileteam.lecture9sample.features.search.repository

import com.rxmobileteam.lecture9sample.data.remote.UnsplashApiService
import com.rxmobileteam.lecture9sample.data.remote.response.SearchPhotosResult
import io.reactivex.rxjava3.core.Single

interface SearchRepository {
  fun searchPhotosRx(query: String, page: Int, perPage: Int): Single<SearchPhotosResult>
  suspend fun searchPhotos(query: String, page: Int, perPage: Int): SearchPhotosResult
}

class SearchRepositoryImpl(private val searchService: UnsplashApiService) : SearchRepository {
  override fun searchPhotosRx(query: String, page: Int, perPage: Int): Single<SearchPhotosResult> {
    return searchService.searchPhotosRx(query, page, perPage)
  }

  override suspend fun searchPhotos(query: String, page: Int, perPage: Int): SearchPhotosResult {
    return searchService.searchPhotos(query = query, page = page, perPage = perPage)
  }
}