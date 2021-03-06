package com.example.jinsool.Select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.GameActivity.GameActivity
import com.example.jinsool.R
import com.example.jinsool.databinding.FragmentQuestionBinding
import com.example.jinsool.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {
    private var _binding: FragmentSelectBinding? = null
    private val binding get() = _binding ?: error("에러")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_select, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureNavigation()

        val result = arguments?.getString("from").toString()
        binding.tvQuestion.text = result
    }

    private fun configureNavigation() {
        binding.btnNext.setOnClickListener {
            (activity as GameActivity).navigateGame()
        }
        binding.btnPenalty.setOnClickListener {
            (activity as GameActivity).navigatePenalty()
        }
    }
}