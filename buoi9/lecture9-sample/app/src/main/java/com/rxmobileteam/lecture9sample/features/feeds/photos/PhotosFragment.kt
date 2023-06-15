package com.rxmobileteam.lecture9sample.features.feeds.photos

import com.rxmobileteam.lecture9sample.base.BaseFragment
import com.rxmobileteam.lecture9sample.databinding.FragmentPhotosBinding

class PhotosFragment : BaseFragment<FragmentPhotosBinding>(FragmentPhotosBinding::inflate) {
  companion object {
    fun newInstance() = PhotosFragment()
  }
}