package com.example.jinsool.MainActivity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import com.example.jinsool.GameActivity.GameActivity
import com.example.jinsool.R
import com.example.jinsool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.ivGreenCircle.setOnClickListener {
            startGameActivity()
        }

        binding.ivRedCircle.setOnClickListener {
            startGameActivity()
        }

        binding.etPlayerCnt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.e("@@@", Integer.parseInt(s.toString()).toString())
                var circleCnt = Integer.parseInt(s.toString())

                for (i in (circleCnt + 1)..8) {
                    var temp = "iv_circle".plus(i)
                    val resId = resources.getIdentifier(temp, "id", packageName)
                    val iv = findViewById<ImageView>(resId)
                    iv.visibility = View.INVISIBLE
                    //iv.setBackgroundColor(Color.BLUE)

                }
            }

            override fun afterTextChanged(s: Editable?) {
                //
            }
        })

    }

    private fun startGameActivity() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
        finish()
    }
}