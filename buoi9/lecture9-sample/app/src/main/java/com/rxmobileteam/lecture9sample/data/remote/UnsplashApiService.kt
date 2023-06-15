package com.rxmobileteam.lecture9sample.data.remote

import com.rxmobileteam.lecture9sample.data.remote.response.CollectionListResponseItem
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {
  @GET("collections")
  suspend fun getCollections(
    @Query("page") page: Int,
    @Query("per_page") perPage: Int,
  ): List<CollectionListResponseItem>

  companion object {
    operator fun invoke(retrofit: Retrofit) = retrofit.create<UnsplashApiService>()
  }
}