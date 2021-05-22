package com.example.jinsool.Question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.GameActivity.GameActivity
import com.example.jinsool.R
import com.example.jinsool.databinding.FragmentPenaltyBinding
import com.example.jinsool.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding ?: error("에러")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        binding.btTemp.setOnClickListener {
            (activity as GameActivity).navigateSelect()
        }
        return binding.root
    }
}