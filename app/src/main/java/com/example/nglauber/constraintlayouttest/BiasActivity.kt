package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import com.example.nglauber.constraintlayouttest.util.onChange
import kotlinx.android.synthetic.main.activity_bias.*

class BiasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bias)
        seekBarHorizontal.onChange { progress, fromUser ->
            moveVertical(progress / 100.toFloat())
        }
        seekBarVertical.onChange { progress, fromUser ->
            moveHorizontal(progress / 100.toFloat())
        }
    }

    private fun moveHorizontal(bias: Float) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.setHorizontalBias(R.id.buttonBias, bias)
        constraintSet.applyTo(constraintLayout)
    }

    private fun moveVertical(bias: Float) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.setVerticalBias(R.id.buttonBias, bias)
        constraintSet.applyTo(constraintLayout)
    }
}
