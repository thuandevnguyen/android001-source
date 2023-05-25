package com.example.demobuoi5.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.demobuoi5.User
import com.example.demobuoi5.databinding.UserItemLayoutBinding

class UserView: ConstraintLayout {
  private lateinit var binding: UserItemLayoutBinding

  constructor(context: Context) : super(context) {
    initViews()
  }
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
    initViews()
  }
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
    initViews()
  }
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
  ){
    initViews()
  }

  private fun initViews() {
    binding = UserItemLayoutBinding.inflate(
      LayoutInflater.from(context),
      this,
      true,
    )
  }

  // method to update UI
  fun setUser(user: User) {
    binding.run {
      textName.text = user.name
      textEmail.text = user.email
    }
  }
}