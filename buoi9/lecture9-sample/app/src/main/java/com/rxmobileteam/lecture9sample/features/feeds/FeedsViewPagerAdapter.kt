package com.rxmobileteam.lecture9sample.features.feeds

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rxmobileteam.lecture9sample.features.feeds.collections.presentation.CollectionsFragment
import com.rxmobileteam.lecture9sample.features.feeds.photos.PhotosFragment

class FeedsViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 2

  override fun createFragment(position: Int): Fragment = when (position) {
    0 -> CollectionsFragment.newInstance()
    1 -> PhotosFragment.newInstance()
    else -> error("Unknown position: $position")
  }
}