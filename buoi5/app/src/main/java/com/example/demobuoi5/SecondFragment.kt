package com.example.demobuoi5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demobuoi5.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment() {
  // saved state
  private var counter = 0

  private var binding: FragmentSecondBinding? = null

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt("counter", counter)
  }

  override fun onViewStateRestored(savedInstanceState: Bundle?) {
    super.onViewStateRestored(savedInstanceState)
    if (savedInstanceState != null) {
      counter = savedInstanceState.getInt("counter")
      Log.d("###", "counter is $counter")
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d("SecondFragment", "arguments: $arguments")
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    logLifecycle("onCreateView")
    binding = FragmentSecondBinding.inflate(
      inflater,
      container,
      false
    )
    return binding!!.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding!!.run {
      buttonBack.setOnClickListener {
        ++counter
        //        parentFragmentManager.popBackStack("TO_SECOND", FragmentManager.POP_BACK_STACK_INCLUSIVE)
      }
    }
  }

  override fun onDestroyView() {
    binding = null
    super.onDestroyView()
  }
}

// tab1 -> tab2
// saveBackStack("tab1") -> restoreBackStack("tab2")

// tab1 <- tab2
// restoreBackStack("tab1") <- saveBackStack("tab2")