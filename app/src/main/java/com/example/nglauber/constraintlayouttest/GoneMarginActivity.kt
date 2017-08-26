package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_gone_margin.*

class GoneMarginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gone_margin)

        button2.setOnClickListener {
            TransitionManager.beginDelayedTransition(constraintLayout)
            button1.visibility = if (button1.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        button4.setOnClickListener {
            TransitionManager.beginDelayedTransition(constraintLayout)
            button3.visibility = if (button3.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }
    }
}
