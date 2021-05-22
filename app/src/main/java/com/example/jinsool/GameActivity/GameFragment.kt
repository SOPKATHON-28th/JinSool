package com.example.jinsool.GameActivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.R
import com.example.jinsool.databinding.FragmentGameBinding
import com.example.jinsool.databinding.FragmentPenaltyBinding

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: error("에러")

    private var prevDegree = 0F

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        binding.btTemp.setOnClickListener {
            (activity as GameActivity).navigateQuestion()
        }

        binding.ivRoulette.setOnClickListener {
            binding.ivRoulette.startAnimation(spin(1000))
        }

        return binding.root
    }

    private fun spin(dur: Int): RotateAnimation {
        val random = (100..500).random().toFloat()
        //val random = 1200F
        if (prevDegree != 0F) {
            prevDegree = random
        }
        val rot = RotateAnimation(
            prevDegree,
            random,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        Log.e("random : ", random.toString())
        rot.duration = dur.toLong()
        rot.interpolator = DecelerateInterpolator()
        binding.ivRoulette.setOnClickListener {
            Log.e("clicked", "clicked")
            binding.ivRoulette.startAnimation(rot)
        }
        rot.fillAfter = true
        return rot
    }
}