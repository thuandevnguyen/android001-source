package com.rxmobileteam.lecture9sample.features.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.rxmobileteam.lecture9sample.data.remote.UnsplashApiService
import com.rxmobileteam.lecture9sample.features.feeds.collections.CollectionUiItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel(
    private val unsplashApiService: UnsplashApiService
) : ViewModel() {

    private val _queryLiveData = MutableLiveData<String>("")
    val queryLiveData get() = _queryLiveData


    val resultSearchPhotos = queryLiveData
        .debounce(
            duration = 500,
            coroutineScope = CoroutineScope(Dispatchers.Main)
        ).switchMap { query ->
            liveData {
                try {
                    val resultSearch = unsplashApiService.searchPhotos(
                        query = query,
                        page = 1,
                        perPage = 10
                    ).results.map {
                        CollectionUiItem(
                            id = it.id,
                            title = it.description ?: "",
                            description = it.description ?: "",
                            coverUrl = it.urls.full

                        )
                    }
                    emit(resultSearch)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    fun queryTextChange(query: String) {
        _queryLiveData.postValue(query)
    }

    fun <T> LiveData<T>.debounce(duration: Long = 1000L, coroutineScope: CoroutineScope) =
        MediatorLiveData<T>().also { mld ->

            val source = this
            var job: Job? = null

            mld.addSource(source) {
                job?.cancel()
                job = coroutineScope.launch {
                    delay(duration)
                    mld.value = source.value
                }
            }
        }
}