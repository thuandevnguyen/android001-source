package com.rxmobileteam.lecture9sample.features.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rxmobileteam.lecture9sample.features.feeds.collections.presentation.CollectionUiItem
import com.rxmobileteam.lecture9sample.features.search.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SearchViewModel(
  private val searchRepository: SearchRepository,
) : ViewModel() {
  private val _queryStateFlow = MutableStateFlow("")

  val resultSearchPhotos: StateFlow<List<CollectionUiItem>> = _queryStateFlow
    .debounce(600)
    .filter { it.isNotBlank() }
    .distinctUntilChanged()
    .flatMapLatest { query ->
      flow {
        emit(
          searchRepository.searchPhotos(
            query = query,
            page = 1,
            perPage = 10,
          )
        )
      }
        .flowOn(Dispatchers.IO)
        .map { Result.success(it) }
        .catch { e -> emit(Result.failure(e)) }
    }
    .map { result ->
      result.fold(
        onSuccess = { photosResult ->
          photosResult.results.map {
            CollectionUiItem(
              id = it.id,
              title = it.description ?: "",
              description = it.description ?: "",
              coverUrl = it.urls.full
            )
          }
        },
        onFailure = { error ->
          Log.e("SearchViewModel", "Error", error)
          emptyList()
        }
      )
    }
    .stateIn(
      scope = viewModelScope,
      started = SharingStarted.Lazily,
      initialValue = emptyList(),
    )

  //region RxJava
  //  private val _querySubject = BehaviorSubject.createDefault("")
//  private val _resultSearchPhotos = MutableLiveData<List<CollectionUiItem>>(emptyList())

//  val resultSearchPhotos get() = _resultSearchPhotos
//
//  private val disposable = _querySubject
//    .debounce(600, TimeUnit.MILLISECONDS)
//    .filter { it.isNotBlank() }
//    .distinctUntilChanged()
//    .switchMap { query ->
//      searchRepository
//        .searchPhotosRx(
//          query = query,
//          page = 1,
//          perPage = 10
//        )
//        .toObservable()
//        .map { Result.success(it) }
//        .onErrorReturn { Result.failure(it) }
//    }
//    .subscribeOn(Schedulers.io())
//    .observeOn(AndroidSchedulers.mainThread())
//    .subscribeBy(
//      onNext = { result ->
//        result.fold(
//          onSuccess = { photosResult ->
//            _resultSearchPhotos.value = photosResult.results.map {
//              CollectionUiItem(
//                id = it.id,
//                title = it.description ?: "",
//                description = it.description ?: "",
//                coverUrl = it.urls.full
//              )
//            }
//          },
//          onFailure = { error ->
//            Log.e("SearchViewModel", "Error", error)
//          }
//        )
//      },
//      onError = { error ->
//        Log.e("SearchViewModel", "Error", error)
//      }
//    )
  //endregion

  override fun onCleared() {
//    disposable.dispose()
    super.onCleared()
  }

  //region LiveData
  //  private val _queryLiveData = MutableLiveData<String>("")
//
//  val resultSearchPhotos = _queryLiveData
//    .debounce(
//      duration = 500,
//      coroutineScope = viewModelScope,
//    ).switchMap { query ->
//      liveData {
//        try {
//          val resultSearch = unsplashApiService.searchPhotos(
//            query = query,
//            page = 1,
//            perPage = 10
//          ).results
//            .map {
//              CollectionUiItem(
//                id = it.id,
//                title = it.description ?: "",
//                description = it.description ?: "",
//                coverUrl = it.urls.full
//              )
//            }
//          emit(resultSearch)
//        } catch (e: CancellationException) {
//          throw e
//        } catch (e: Exception) {
//          e.printStackTrace()
//        }
//      }
//    }
  //endregion

  fun queryTextChange(query: String) {
//    _queryLiveData.value = query
//    _querySubject.onNext(query)
    _queryStateFlow.value = query
  }

  companion object {
//    fun factory() = viewModelFactory {
//      addInitializer(SearchViewModel::class) {
//        SearchViewModel(unsplashApiService = ServiceLocator.unsplashApiService)
//      }
//    }
  }
}
