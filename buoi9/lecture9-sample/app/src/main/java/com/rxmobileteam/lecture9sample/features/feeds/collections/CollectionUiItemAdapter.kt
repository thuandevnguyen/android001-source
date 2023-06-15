package com.rxmobileteam.lecture9sample.features.feeds.collections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.rxmobileteam.lecture9sample.GlideRequests
import com.rxmobileteam.lecture9sample.databinding.CollectionItemLayoutBinding

object CollectionUiItemDiffUtilCallback : DiffUtil.ItemCallback<CollectionUiItem>() {
  override fun areItemsTheSame(oldItem: CollectionUiItem, newItem: CollectionUiItem): Boolean =
    oldItem.id == newItem.id

  override fun areContentsTheSame(oldItem: CollectionUiItem, newItem: CollectionUiItem): Boolean =
    oldItem == newItem
}

class CollectionUiItemAdapter(
  private val glide: GlideRequests
) :
  ListAdapter<CollectionUiItem, CollectionUiItemAdapter.VH>(CollectionUiItemDiffUtilCallback) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
    CollectionItemLayoutBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
  )

  override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

  inner class VH(private val binding: CollectionItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CollectionUiItem) {
      binding.run {
        textViewTitle.text = item.title
        textViewDescription.text = item.description

        glide
          .load(item.coverUrl)
          .fitCenter()
          .centerCrop()
          .transition(withCrossFade())
          .into(imageView)
      }
    }
  }

}