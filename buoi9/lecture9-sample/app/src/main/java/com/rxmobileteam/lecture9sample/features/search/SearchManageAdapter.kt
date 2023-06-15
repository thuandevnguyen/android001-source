package com.rxmobileteam.lecture9sample.features.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchManageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
       return when (position) {
            TAB_PHOTOS -> SearchPhotoFragment.newInstance()
            TAB_USERS -> SearchUserFragment.newInstance()
            else -> throw IllegalStateException("Invalid Position")
        }
    }

    companion object {
        const val TAB_PHOTOS = 0
        const val TAB_USERS = 1
    }

}