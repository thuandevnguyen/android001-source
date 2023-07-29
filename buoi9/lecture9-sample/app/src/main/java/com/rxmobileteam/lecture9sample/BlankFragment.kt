package com.rxmobileteam.lecture9sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.rxmobileteam.lecture9sample.databinding.FragmentBlankBinding

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
  private var _binding: FragmentBlankBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentBlankBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.tvNavigationFragment2.setOnClickListener {
      val options = NavOptions.Builder()
      options.setPopUpTo(
        destinationId = R.id.blankFragment, inclusive = false
      )
      findNavController().navigate(
        resId = R.id.action_blankFragment_to_blankFragment2,
        args = bundleOf("name" to "Hello"),
        navOptions = options.build()
      )
    }
  }
}