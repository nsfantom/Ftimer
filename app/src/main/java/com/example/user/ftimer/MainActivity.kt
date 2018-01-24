package com.example.user.ftimer

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var cdt: CountDownTimer = object : CountDownTimer(10000, 1000) {
        override fun onTick(p0: Long) {
            currentSec = (p0 / 1000).toInt()
            updateUi()
        }

        override fun onFinish() {
            currentSec = 0
            updateUi()
        }
    };

    var currentSec: Int = 30
    var red: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener({
            cdt.cancel()
            red = true
            cdt.start()
        })

        btnStop.setOnClickListener({
            cdt.cancel()
        })
    }

    fun updateUi() {
        tvCounter?.text = currentSec.toString()
        red = if (red) {
            tvCounter.setTextColor(Color.RED)
            false
        } else {
            tvCounter.setTextColor(Color.BLUE)
            true
        }
    }
}
