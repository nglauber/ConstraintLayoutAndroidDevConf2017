package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.constraint.ConstraintSet.*
import android.support.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_constraint_set.*

class ConstraintSetActivity : AppCompatActivity() {

    var constraintSet = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set)

        radioGroup.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.radioLeft -> moveLeft()
                R.id.radioRight -> moveRight()
                R.id.radioTop -> moveTop()
                R.id.radioBottom -> moveBottom()
            }
        }
    }

    private fun moveBottom() {
        move {
            connectIcon(TOP, BOTTOM)
            centerHorizontal()
        }
    }

    private fun moveTop() {
        move {
            connectIcon(BOTTOM, TOP)
            centerHorizontal()
        }
    }

    private fun moveRight() {
        move {
            connectIcon(START, END)
            centerVertical()
        }
    }

    private fun moveLeft() {
        move {
            connectIcon(END, START)
            centerVertical()
        }
    }

    private fun connectIcon(from: Int, to: Int) {
        constraintSet.connect(R.id.imageIcon, from, R.id.imageLogo, to)
    }

    private fun centerVertical() {
        constraintSet.connect(R.id.imageIcon, TOP, R.id.imageLogo, TOP)
        constraintSet.connect(R.id.imageIcon, BOTTOM, R.id.imageLogo, BOTTOM)
    }

    private fun centerHorizontal() {
        constraintSet.connect(R.id.imageIcon, START, R.id.imageLogo, START)
        constraintSet.connect(R.id.imageIcon, END, R.id.imageLogo, END)
    }

    private fun move(movement:()->Unit) {
        TransitionManager.beginDelayedTransition(constraintLayout)
        constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_constraint_set)
        constraintSet.clear(R.id.imageIcon, BOTTOM)
        constraintSet.clear(R.id.imageIcon, TOP)
        constraintSet.clear(R.id.imageIcon, START)
        constraintSet.clear(R.id.imageIcon, END)
        movement()
        constraintSet.applyTo(constraintLayout)
    }

}
