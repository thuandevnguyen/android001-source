package com.rxmobileteam.lecture9sample.data.remote.response

data class SearchPhotosResult(
    val total : Int,
    val total_pages : Int,
    val results : List<CollectionListResponseItem.CoverPhoto>
)
