package com.example.demobuoi5

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demobuoi5.databinding.UserItemLayoutBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.VH>() {
  private var count = 0

  private var users: List<User> = emptyList()

  fun setData(users: List<User>) {
    this.users = users
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    Log.d("####", "create ViewHolder ${++count}")
    val binding = UserItemLayoutBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
    return VH(binding)
  }

  override fun getItemCount(): Int {
    return users.size
  }

  override fun onBindViewHolder(holder: VH, position: Int) {
    // update UI for each item
    val user = users[position]
    holder.bind(user)
  }


  class VH(private val binding: UserItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
      binding.run {
        textName.text = user.name
        textEmail.text = user.email
      }
    }

  }
}