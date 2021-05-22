package com.example.jinsool.GameActivity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.jinsool.Penalty.PenaltyFragment
import com.example.jinsool.Question.QuestionFragment
import com.example.jinsool.R
import com.example.jinsool.Select.SelectFragment
import com.example.jinsool.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val gameFragment by lazy { GameFragment() }
    private val questionFragment by lazy { QuestionFragment() }
    private val selectFragment by lazy { SelectFragment() }
    private val penaltyFragment by lazy { PenaltyFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(LayoutInflater.from(this))
        navigateGame()
        setContentView(binding.root)
    }

    fun navigateQuestion() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_root, questionFragment)
        transaction.commit()
    }

    fun navigateSelect(from : String) {
        val bundle = Bundle()
        bundle.putString("from", from)
        selectFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_root, selectFragment)
        transaction.commit()
    }

    fun navigateGame() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_root, gameFragment)
        transaction.commit()
    }

    fun navigatePenalty() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_root, penaltyFragment)
        transaction.commit()
    }
}
