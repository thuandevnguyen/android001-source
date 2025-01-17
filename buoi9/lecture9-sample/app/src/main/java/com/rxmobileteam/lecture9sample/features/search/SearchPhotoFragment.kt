package com.rxmobileteam.lecture9sample.features.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rxmobileteam.lecture9sample.GlideApp
import com.rxmobileteam.lecture9sample.base.BaseFragment
import com.rxmobileteam.lecture9sample.databinding.FragmentSearchPhotosBinding
import com.rxmobileteam.lecture9sample.extensions.setupVertically
import com.rxmobileteam.lecture9sample.features.feeds.collections.presentation.CollectionUiItemAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class SearchPhotoFragment :
  BaseFragment<FragmentSearchPhotosBinding>(FragmentSearchPhotosBinding::inflate) {

  private val collectionUiItemAdapter by lazy(LazyThreadSafetyMode.NONE) {
    CollectionUiItemAdapter(
      glide = GlideApp.with(this)
    )
  }

//
//  private val viewModel by activityViewModels<SearchViewModel>(
//    factoryProducer = SearchViewModel::factory,
//  )

  private val viewModel by activityViewModel<SearchViewModel>()


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.recyclerViewSearchPhoto.setupVertically(
      collectionUiItemAdapter
    )

//    viewModel.resultSearchPhotos.observe(viewLifecycleOwner) {
//      collectionUiItemAdapter.submitList(it)
//    }

    viewLifecycleOwner.lifecycleScope.launch {
      viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
        viewModel.resultSearchPhotos.collect {
          collectionUiItemAdapter.submitList(it)
        }
      }
    }
  }


  companion object {
    fun newInstance() = SearchPhotoFragment()
  }
}
