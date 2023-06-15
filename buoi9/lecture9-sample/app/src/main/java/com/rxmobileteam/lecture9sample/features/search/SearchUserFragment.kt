package com.rxmobileteam.lecture9sample.features.search

import android.os.Bundle
import android.view.View
import com.rxmobileteam.lecture9sample.base.BaseFragment
import com.rxmobileteam.lecture9sample.databinding.FragmentSearchUsersBinding

class SearchUserFragment :
  BaseFragment<FragmentSearchUsersBinding>(FragmentSearchUsersBinding::inflate) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  companion object {
    fun newInstance() = SearchUserFragment()
  }
}