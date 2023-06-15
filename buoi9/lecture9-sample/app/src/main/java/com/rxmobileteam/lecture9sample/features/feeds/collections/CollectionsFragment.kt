package com.rxmobileteam.lecture9sample.features.feeds.collections

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rxmobileteam.lecture9sample.GlideApp
import com.rxmobileteam.lecture9sample.base.BaseFragment
import com.rxmobileteam.lecture9sample.databinding.FragmentCollectionsBinding
import kotlin.LazyThreadSafetyMode.NONE

class CollectionsFragment : BaseFragment<FragmentCollectionsBinding>(FragmentCollectionsBinding::inflate) {
  private val viewModel by viewModels<CollectionsViewModel>(
    factoryProducer = CollectionsViewModel::factory
  )

  private val collectionUiItemAdapter by lazy(NONE) {
    CollectionUiItemAdapter(
      glide = GlideApp.with(this)
    )
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupViews()
    bindVM()
  }

  private fun bindVM() {
    viewModel.uiStateLiveData.observe(viewLifecycleOwner) { uiState ->
      when(uiState) {
        is CollectionsUiState.FirstPageFailure -> {
          collectionUiItemAdapter.submitList(emptyList())

          binding.run {
            progressCircular.isVisible = false
            button.isVisible = true
            button.text = "First page failed. Retry"
          }
        }
        CollectionsUiState.FirstPageLoading -> {
          collectionUiItemAdapter.submitList(emptyList())

          binding.run {
            progressCircular.isVisible = true
            button.isVisible = false
          }
        }
        is CollectionsUiState.Page -> {
          collectionUiItemAdapter.submitList(uiState.items)

          binding.run {
            progressCircular.isVisible = uiState.isLoading

            button.isVisible = uiState.error !== null
            button.text = "Next page failed. Retry"
          }
        }
      }
    }
  }

  private fun setupViews() {
    binding.recyclerCollections.run {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = collectionUiItemAdapter
    }
  }

  override fun onDestroyView() {
    binding.recyclerCollections.adapter = null
    super.onDestroyView()
  }


  companion object {
    fun newInstance() = CollectionsFragment()
  }
}