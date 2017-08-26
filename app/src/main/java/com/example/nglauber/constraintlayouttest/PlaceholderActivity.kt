package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_placeholder.*

class PlaceholderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)

        buttonA.setOnClickListener(this::buttonClick)
        buttonB.setOnClickListener(this::buttonClick)
        buttonC.setOnClickListener(this::buttonClick)
    }

    private fun buttonClick(view: View) {
        TransitionManager.beginDelayedTransition(constraintLayout)
        placeholder.setContentId(view.id)
    }
}
