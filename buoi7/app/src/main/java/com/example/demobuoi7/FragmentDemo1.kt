package com.example.demobuoi7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.demobuoi7.databinding.FragmentDemo1Binding

class FragmentDemo1 : Fragment() {

    private var _binding: FragmentDemo1Binding? = null

    private val binding get() = _binding!!

    private val viewModel by activityViewModels<CounterViewModel>(

    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDemo1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCount.setOnClickListener {
            viewModel.counter()
        }
    }
}