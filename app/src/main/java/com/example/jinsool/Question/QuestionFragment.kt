package com.example.jinsool.Question

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.GameActivity.GameActivity
import com.example.jinsool.R
import com.example.jinsool.databinding.FragmentPenaltyBinding
import com.example.jinsool.databinding.FragmentQuestionBinding
import kotlin.math.roundToInt

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding ?: error("에러")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startCountDownTimer()
    }

    private fun startCountDownTimer() {
        val countDownTimer : CountDownTimer = object: CountDownTimer(8000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = "${(millisUntilFinished.toFloat() / 1000.0f).roundToInt()}"
            }

            override fun onFinish() {
                (activity as GameActivity).navigateSelect()
            }

        }
        countDownTimer.start()
    }

}