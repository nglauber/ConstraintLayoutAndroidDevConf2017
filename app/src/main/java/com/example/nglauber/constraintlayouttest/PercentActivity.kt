package com.example.nglauber.constraintlayouttest

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import com.example.nglauber.constraintlayouttest.util.onChange
import kotlinx.android.synthetic.main.activity_percent.*

class PercentActivity : AppCompatActivity() {

    val set = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_percent)

        set.clone(constraintLayout)

        seekBar.onChange { progress, fromUser ->
            if (fromUser) updateButtonSize(progress)
        }
    }

    private fun updateButtonSize(value: Int) {
        val percent = value / 100f
        val params = buttonPercent.layoutParams as ConstraintLayout.LayoutParams
        params.width = 0
        params.matchConstraintDefaultWidth = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_PERCENT
        params.matchConstraintPercentWidth = percent
        buttonPercent.layoutParams = params
        buttonPercent.text = "Button $value%"
    }
}
