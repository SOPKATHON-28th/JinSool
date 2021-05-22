package com.example.jinsool.Question

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jinsool.GameActivity.GameActivity
import com.example.jinsool.R
import com.example.jinsool.api.PenalityCreater
import com.example.jinsool.databinding.FragmentPenaltyBinding
import com.example.jinsool.databinding.FragmentQuestionBinding
import com.example.jinsool.request.RequestData
import com.example.jinsool.response.PlayerItem
import com.example.jinsool.response.ResponsePlayerData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding ?: error("에러")

    var position : Int = 0

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

        val requestData = RequestData(2, 1)
        val call : Call<ResponsePlayerData> = PenalityCreater.penalityService.getQuestion(RequestData(2, 1))
        Log.d("아아", "success")
        call.enqueue(object : Callback <ResponsePlayerData> {
            override fun onResponse(
                call: Call<ResponsePlayerData>,
                response: Response<ResponsePlayerData>
            ) {
                if (response.isSuccessful) {
                    Log.d("서버", "success")
                    val questionList = response.body()?.data?.question
                    Log.d("ttt", response.body()?.data.toString())
                    Log.d("서버", "${questionList}")
                    binding.tvQuestion.setText(questionList?.get(position++)?.title)
                    if(position == questionList?.size){
                       Log.d("마지막 배열", "dd")
                       position = 0
                    }
                } else {
                    Log.d("서버", "fail")
                }
            }

            override fun onFailure(call: Call<ResponsePlayerData>, t: Throwable) {
                Log.d("서버", "onfail")
            }
        })

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