package com.rxmobileteam.lecture9sample.features.feeds.collections

sealed interface CollectionsUiState {
  object FirstPageLoading : CollectionsUiState

  data class FirstPageFailure(val error: Throwable) : CollectionsUiState

  data class Page(
    val pageNumber: Int,
    val items: List<CollectionUiItem>,
    val isLoading: Boolean,
    val error: Throwable?
  ) : CollectionsUiState
}

data class CollectionUiItem(
  val id: String,
  val title: String,
  val description: String,
  val coverUrl: String
)