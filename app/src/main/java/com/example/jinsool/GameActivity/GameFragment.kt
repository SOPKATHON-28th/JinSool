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
    private var loser = -1
    private var playerNum = 5

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
        val randomDegree = (100..359).random().toFloat()
        //val random = 1200F
        val rot = RotateAnimation(
            0F,
            randomDegree,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        Log.e("random : ", randomDegree.toString())
        rot.duration = dur.toLong()
        rot.interpolator = DecelerateInterpolator()
        binding.ivRoulette.setOnClickListener {
            Log.e("clicked", "clicked")
            binding.ivRoulette.startAnimation(rot)
        }
        rot.fillAfter = true
        Log.e("loser", checkLoser(randomDegree.toInt()).toString())
        return rot
    }

    private fun checkLoser(deg: Int): Int {
        when (playerNum) {
            2 -> {
                when (deg) {
                    in 1..179 -> {
                        loser = 1
                    }
                    in 180..359 -> {
                        loser = 2
                    }
                }
            }
            3 -> {
                when (deg) {
                    in 1..119 -> {
                        loser = 1
                    }
                    in 120..239 -> {
                        loser = 2
                    }
                    in 240..359 -> {
                        loser = 3
                    }
                }
            }
            4 -> {
                when (deg) {
                    in 1..89 -> {
                        loser = 1
                    }
                    in 90..179 -> {
                        loser = 2
                    }
                    in 180..269 -> {
                        loser = 3
                    }
                    in 279..359 -> {
                        loser = 4
                    }
                }
            }
            5 -> {
                when (deg) {
                    in 1..71 -> {
                        loser = 1
                    }
                    in 72..143 -> {
                        loser = 2
                    }
                    in 144..215 -> {
                        loser = 3
                    }
                    in 216..287 -> {
                        loser = 4
                    }
                    in 288..359 -> {
                        loser = 5
                    }
                }
            }
            6 -> {
                when (deg) {
                    in 1..59 -> {
                        loser = 1
                    }
                    in 60..119 -> {
                        loser = 2
                    }
                    in 120..179 -> {
                        loser = 3
                    }
                    in 180..239 -> {
                        loser = 4
                    }
                    in 240..299 -> {
                        loser = 5
                    }
                    in 300..359 -> {
                        loser = 6
                    }
                }
            }
        }
        return loser
    }

}