package com.example.demobuoi5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.demobuoi5.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment() {
  private var binding: FragmentFirstBinding? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d("FirstFragment", "arguments: $arguments")
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    logLifecycle("onCreateView")
    binding = FragmentFirstBinding.inflate(
      inflater,
      container,
      false
    )
    return binding!!.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding!!.run {
      button.setOnClickListener {
        requireActivity().supportFragmentManager.commit {
          setReorderingAllowed(true)

          replace<SecondFragment>(
            containerViewId = R.id.container,
            tag = "SecondFragment",
            args = bundleOf(
              "key1" to 1,
              "key2" to "hello",
              "key3" to arrayListOf("1", "2", "3")
            ),
          )

          addToBackStack("TO_SECOND")
        }
      }
    }
  }

  override fun onDestroyView() {
    binding = null
    super.onDestroyView()
  }
}