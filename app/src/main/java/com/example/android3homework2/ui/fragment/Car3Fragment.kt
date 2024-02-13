package com.example.android3homework2.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android3homework2.R
import com.example.android3homework2.databinding.FragmentCar3Binding
import com.example.android3homework2.ui.adapter.CarAdapter
import com.example.android3homework2.ui.viewModel.Car3ViewModel

class Car3Fragment : Fragment() {

    private var _binding: FragmentCar3Binding? = null
    private val binding get() = _binding!!
    private val carAdapter = CarAdapter()
    private val viewModel by activityViewModels<Car3ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCar3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        toGoSecondFragment()
    }

    private fun initialize() = with(binding) {
        viewModel.carLiveData.observe(viewLifecycleOwner) { uiState ->
            rvCar3.adapter = carAdapter
            uiState.success?.let {
                carAdapter.setCar(it.toMutableList())
            }
        }
    }

    private fun toGoSecondFragment() = with(binding) {
        btnFirst.setOnClickListener {
            progressbar.isVisible = true
            Handler().postDelayed(
                {
                    progressbar.isVisible = false
                    findNavController().navigate(R.id.action_cars3Fragment_to_addFragment2)
                },
                3000
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}