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
import com.example.jinsool.api.PenalityCreater
import com.example.jinsool.databinding.FragmentGameBinding
import com.example.jinsool.databinding.FragmentPenaltyBinding
import response.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val call : Call<Int> = PenalityCreater.penalityService
            .getRequest()

        call.enqueue(object : Callback<Int> {
            override fun onResponse(
                call: Call<Int>,
                response: Response<Int>) {
                if(response.isSuccessful){
                    Log.d("서버통신","성공!!!")
                }
                else{
                    Log.d("서버통신","실패ㅠㅠ")

                }

            }

            override fun onFailure(call: Call<Int>, t: Throwable) {
                Log.d("NetworkTest","error:$t")
            }


        })










    }
}