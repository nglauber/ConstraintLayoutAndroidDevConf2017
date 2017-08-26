package com.example.nglauber.constraintlayouttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_group.*

class GroupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        switchVisibility.setOnCheckedChangeListener({ _, checked ->
            group.visibility = if (checked) View.VISIBLE else View.GONE
        })
    }
}
