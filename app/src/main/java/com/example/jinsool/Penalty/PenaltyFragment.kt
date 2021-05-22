package com.example.jinsool.Penalty

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.GameActivity.GameActivity
import com.example.jinsool.R
import com.example.jinsool.databinding.FragmentGameBinding
import com.example.jinsool.databinding.FragmentPenaltyBinding

class PenaltyFragment : Fragment() {
    private var _binding: FragmentPenaltyBinding? = null
    private val binding get() = _binding ?: error("에러")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_penalty, container, false)
        binding.btTemp.setOnClickListener {
            (activity as GameActivity).navigateGame()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val random = (0..2).random()
        when (random){
            0-> binding.penalty.setImageResource(R.drawable.and)
            1-> binding.penalty.setImageResource(R.drawable.beme_icon)
            else -> binding.penalty.setImageResource(R.drawable.logo)
        }
        Log.d("랜덤값","$random")


    }
}