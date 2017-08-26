package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_ratio.*

class RatioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratio)

        radioGroupRatio.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton1_1 -> resize("1:1")
                R.id.radioButton4_3 -> resize("h,4:3")
                R.id.radioButton16_9 -> resize("h,16:9")
            }
        }
    }

    private fun resize(ratio: String) {
        TransitionManager.beginDelayedTransition(constraintLayout)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.setDimensionRatio(R.id.imageLogo, ratio)
        constraintSet.applyTo(constraintLayout)
    }
}
