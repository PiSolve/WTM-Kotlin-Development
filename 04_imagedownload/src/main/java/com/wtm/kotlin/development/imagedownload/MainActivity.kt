package com.wtm.kotlin.development.imagedownload

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

// using Glide : https://pbs.twimg.com/media/D6tW3vbX4AUmSNl.png:large
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Glide.with(this)
                    .load("https://pbs.twimg.com/media/D6tW3vbX4AUmSNl.png:large")
                    .into(imageview)
        }
    }
}
