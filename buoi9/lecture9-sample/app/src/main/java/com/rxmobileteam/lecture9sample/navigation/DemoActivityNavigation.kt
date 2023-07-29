package com.rxmobileteam.lecture9sample.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rxmobileteam.lecture9sample.R
import com.rxmobileteam.lecture9sample.databinding.ActivityDemoNavigationComponentBinding

class DemoActivityNavigation : AppCompatActivity() {

  private lateinit var navController: NavController

  private val binding by lazy(LazyThreadSafetyMode.NONE) {
    ActivityDemoNavigationComponentBinding.inflate(
      layoutInflater
    )
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    initNavigation()
  }

  private fun initNavigation() {
    val navHostFragment =
      supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
    navController = navHostFragment.navController
    val navGraph = navController.navInflater.inflate(R.navigation.demo_nav_graph)
    val destination = R.id.blankFragment
    navGraph.setStartDestination(destination)
    navController.graph = navGraph
  }

}