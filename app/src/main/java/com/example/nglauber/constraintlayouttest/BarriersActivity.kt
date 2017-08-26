package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nglauber.constraintlayouttest.util.onTextChanged
import kotlinx.android.synthetic.main.activity_barriers.*

class BarriersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barriers)
        editText1.onTextChanged { s-> onTextChanged(textView1, s) }
        editText2.onTextChanged { s-> onTextChanged(textView2, s) }
        editText3.onTextChanged { s-> onTextChanged(textView3, s) }
    }

    private fun onTextChanged(textView: TextView, s: String) {
        textView.text = s
//        textView.invalidate()
        textView.requestLayout()
//        barrier1.invalidate()
    }
}
