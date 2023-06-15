package com.rxmobileteam.lecture9sample.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rxmobileteam.lecture9sample.ServiceLocator
import com.rxmobileteam.lecture9sample.data.remote.UnsplashApiService
import com.rxmobileteam.lecture9sample.features.feeds.collections.CollectionUiItem
import com.rxmobileteam.lecture9sample.utils.debounce
import kotlinx.coroutines.CancellationException

class SearchViewModel(
  private val unsplashApiService: UnsplashApiService
) : ViewModel() {

  private val _queryLiveData = MutableLiveData<String>("")

  val queryLiveData: LiveData<String> get() = _queryLiveData

  val resultSearchPhotos = queryLiveData
    .debounce(
      duration = 500,
      coroutineScope = viewModelScope,
    ).switchMap { query ->
      liveData {
        try {
          val resultSearch = unsplashApiService.searchPhotos(
            query = query,
            page = 1,
            perPage = 10
          ).results
            .map {
              CollectionUiItem(
                id = it.id,
                title = it.description ?: "",
                description = it.description ?: "",
                coverUrl = it.urls.full
              )
            }
          emit(resultSearch)
        } catch (e: CancellationException) {
          throw e
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }

  fun queryTextChange(query: String) {
    _queryLiveData.value = query
  }

  companion object {
    fun factory() = viewModelFactory {
      addInitializer(SearchViewModel::class) {
        SearchViewModel(unsplashApiService = ServiceLocator.unsplashApiService)
      }
    }
  }
}
