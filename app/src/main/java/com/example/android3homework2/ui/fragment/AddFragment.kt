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
import com.example.android3homework2.data.model.Car
import com.example.android3homework2.databinding.FragmentAddBinding
import com.example.android3homework2.ui.viewModel.Car3ViewModel

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<Car3ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()
    }

    private fun goBack()  = with(binding) {
        btnElement.setOnClickListener {
            progressbarTwo.isVisible = true
            Handler().postDelayed({
                progressbarTwo.isVisible = false
                viewModel.addBleach(
                    Car(
                        image = R.drawable.ferrari,
                        name =  etName.text.toString().trim(),
                        riderNumber = etNumber.text.toString().trim()
                    )
                )
                findNavController().navigateUp()
            }, 2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}