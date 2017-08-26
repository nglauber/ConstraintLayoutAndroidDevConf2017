package com.example.nglauber.constraintlayouttest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val options = listOf(
                "Bias" to BiasActivity::class.java,
                "Gone Margin" to GoneMarginActivity::class.java,
                "Chains" to ChainsActivity::class.java,
                "Ratio" to RatioActivity::class.java,
                "ConstraintSet" to ConstraintSetActivity::class.java,
                "Barriers" to BarriersActivity::class.java,
                "Group" to GroupActivity::class.java,
                "Placeholder" to PlaceholderActivity::class.java,
                "Percent" to PercentActivity::class.java,
                "Netflix" to NetflixActivity::class.java
        )

        listView.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                options.map { it.first })

        listView.setOnItemClickListener { _, _, position, _ ->
            startActivity(Intent(this, options[position].second))
        }
    }
}
