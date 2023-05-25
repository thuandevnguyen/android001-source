package com.example.demobuoi5

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demobuoi5.databinding.UserItemLayoutBinding


object UserItemCallback : DiffUtil.ItemCallback<User>() {
  override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
    // compare by id, ...
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
    // equals
    return oldItem == newItem
  }

}

class UserListAdapter(
  private val onClickItem: (User) -> Unit
) : ListAdapter<User, UserListAdapter.VH>(UserItemCallback) {
  private var count = 0

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    Log.d("####", "create ViewHolder ${++count}")
    val binding = UserItemLayoutBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
    return VH(binding)
  }

  override fun onBindViewHolder(holder: VH, position: Int) {
    // update UI for each item
    val user = getItem(position)
    holder.bind(user)
  }

  inner class VH(private val binding: UserItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
      binding.root.setOnClickListener {
        val pos = adapterPosition
        if (pos == RecyclerView.NO_POSITION) {
          return@setOnClickListener
        }

        val clickedItem = getItem(pos)
        onClickItem(clickedItem)
      }
    }

    fun bind(user: User) {
      binding.run {
        textName.text = user.name
        textEmail.text = user.email
      }
    }

  }
}