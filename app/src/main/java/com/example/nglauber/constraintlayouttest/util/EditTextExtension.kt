package com.example.nglauber.constraintlayouttest.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

infix fun EditText.onTextChanged(callback: (String)->Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            callback(p0.toString())
        }
    })
}
