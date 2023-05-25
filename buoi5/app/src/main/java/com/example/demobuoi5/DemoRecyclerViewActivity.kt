package com.example.demobuoi5

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demobuoi5.databinding.ActivityDemoRecyclerViewBinding
import java.util.UUID

data class User(
  val id: String,
  val name: String,
  val email: String
)

class DemoRecyclerViewActivity : AppCompatActivity() {
  private val binding by lazy(LazyThreadSafetyMode.NONE) {
    ActivityDemoRecyclerViewBinding.inflate(layoutInflater)
  }

  // NOTE:
  // Using Readonly List/ Immutable List
  // Do not setter for each item -> must use copy of data class
  //
  // map -> update items
  // filter -> remove items
  // plus (+) -> insert item

  private val userAdapter = UserListAdapter(
    onClickItem = ::removeItem
  )

  private var users: List<User> = emptyList()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    // setup recyclerview
    setupRecyclerview()

    binding.floatingActionButton.setOnClickListener {
      //insertNewUser()
      // users = users.sortedBy { it.id }
      users = users.map { item ->
        if ("new" in item.name) {
          item.copy(name = item.name.replace("new", ""))
        } else {
          item
        }
      }
      userAdapter.submitList(users)

      binding.canvasView.setFilledColor(Color.RED)
    }

    users = List(size = 100) { index ->
      User(
        id = UUID.randomUUID().toString(),
        name = "Name $index",
        email = "email_$index@gmail.com"
      )
    }
    userAdapter.submitList(users)


    binding.userView.setUser(
      users.last()
    )
  }

  private fun insertNewUser() {
    val newUser = User(
      id = UUID.randomUUID().toString(),
      name = "Name ${users.size}",
      email = "email_${users.size}@gmail.com"
    )
    users = listOf(newUser) + users
    userAdapter.submitList(users) {
      binding.recyclerView.scrollToPosition(0)
    }
  }

  private fun removeItem(needUpdate: User) {
    users = users.map { item ->
      if (item.id == needUpdate.id) item.copy(name = item.name + " new ")
      else item
    }
    userAdapter.submitList(users)
  }

  private fun setupRecyclerview() {
    binding.recyclerView.run {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(context)
      adapter = userAdapter
    }
  }
}