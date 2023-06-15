package com.rxmobileteam.lecture9sample.data.remote.response

data class SearchUserResult(
  val total: Int,
  val total_pages: Int,
  val results: List<CollectionListResponseItem.User>
)