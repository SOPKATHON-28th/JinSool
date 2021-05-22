package com.example.jinsool.GameActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.R
import com.example.jinsool.databinding.FragmentGameBinding
import com.example.jinsool.databinding.FragmentPenaltyBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: error("에러")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        binding.btTemp.setOnClickListener {
            (activity as GameActivity).navigateQuestion()
        }
        return binding.root
    }
}