package com.example.nglauber.constraintlayouttest.util

import android.widget.SeekBar

infix fun SeekBar.onChange(callback: (Int,Boolean)->Unit){
    this.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            callback(progress, fromUser)
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {
        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
        }
    })
}
