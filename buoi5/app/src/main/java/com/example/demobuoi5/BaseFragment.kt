package com.example.demobuoi5

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
  @CallSuper
  override fun onAttach(context: Context) {
    super.onAttach(context)
    logLifecycle("onAttach context=$context")
  }

  @CallSuper
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    logLifecycle("onCreate savedInstanceState=$savedInstanceState")
  }

  @CallSuper
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    logLifecycle("onViewCreated")
  }

  @CallSuper
  override fun onStart() {
    super.onStart()
    logLifecycle("onStart")
  }

  @CallSuper
  override fun onResume() {
    super.onResume()
    logLifecycle("onResume")
  }

  @CallSuper
  override fun onPause() {
    super.onPause()
    logLifecycle("onPause")
  }

  @CallSuper
  override fun onStop() {
    super.onStop()
    logLifecycle("onStop")
  }

  @CallSuper
  override fun onDestroyView() {
    super.onDestroyView()
    logLifecycle("onDestroyView")
  }

  @CallSuper
  override fun onDestroy() {
    super.onDestroy()
    logLifecycle("onDestroy")
  }

  @CallSuper
  override fun onDetach() {
    super.onDetach()
    logLifecycle("onDetach")
  }

  protected fun logLifecycle(name: String) {
    val tag = this::class.java.simpleName
    Log.d(tag, "$this -> $name")
  }
}