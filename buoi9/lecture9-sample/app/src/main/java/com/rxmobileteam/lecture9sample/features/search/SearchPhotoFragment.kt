package com.rxmobileteam.lecture9sample.features.search

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rxmobileteam.lecture9sample.GlideApp
import com.rxmobileteam.lecture9sample.ServiceLocator
import com.rxmobileteam.lecture9sample.base.BaseFragment
import com.rxmobileteam.lecture9sample.databinding.FragmentFeedsBinding
import com.rxmobileteam.lecture9sample.databinding.FragmentSearchPhotosBinding
import com.rxmobileteam.lecture9sample.extensions.createAdapter
import com.rxmobileteam.lecture9sample.features.feeds.collections.CollectionUiItemAdapter

class SearchPhotoFragment :
    BaseFragment<FragmentSearchPhotosBinding>(FragmentSearchPhotosBinding::inflate) {

    private val collectionUiItemAdapter by lazy(LazyThreadSafetyMode.NONE) {
        CollectionUiItemAdapter(
            glide = GlideApp.with(this)
        )
    }


    private val viewModel by activityViewModels<SearchViewModel>(
        factoryProducer = {
            viewModelFactory {
                addInitializer(SearchViewModel::class) {
                    SearchViewModel(unsplashApiService = ServiceLocator.unsplashApiService)
                }
            }
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewSearchPhoto.createAdapter(
            collectionUiItemAdapter
        )
        viewModel.resultSearchPhotos.observe(viewLifecycleOwner) {
            collectionUiItemAdapter.submitList(it)
        }
    }


    companion object {
        fun newInstance() = SearchPhotoFragment()
    }
}