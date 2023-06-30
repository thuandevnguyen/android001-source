package com.rxmobileteam.lecture9sample.data.remote

import com.rxmobileteam.lecture9sample.data.remote.response.CollectionListResponseItem
import com.rxmobileteam.lecture9sample.data.remote.response.SearchPhotosResult
import com.rxmobileteam.lecture9sample.data.remote.response.SearchUserResult
import io.reactivex.rxjava3.core.Single
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


  @GET("search/photos")
  suspend fun searchPhotos(
    @Query("query") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int,
  ): SearchPhotosResult

  @GET("search/photos")
  suspend fun searchUsers(
    @Query("query") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int,
  ): SearchUserResult

  @GET("search/photos")
  fun searchUsersRx(
    @Query("query") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int,
  ): Single<SearchUserResult>

  @GET("search/photos")
  fun searchPhotosRx(
    @Query("query") query: String,
    @Query("page") page: Int,
    @Query("per_page") perPage: Int,
  ): Single<SearchPhotosResult>

  companion object {
    operator fun invoke(retrofit: Retrofit) = retrofit.create<UnsplashApiService>()
  }
}