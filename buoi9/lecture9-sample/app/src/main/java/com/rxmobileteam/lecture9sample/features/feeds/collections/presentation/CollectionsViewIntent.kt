package com.rxmobileteam.lecture9sample.features.feeds.collections.presentation

sealed interface CollectionsViewIntent {
  object LoadNextPage: CollectionsViewIntent
  object Retry: CollectionsViewIntent
}