package com.mmicu.demo.feed.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mmicu.demo.R
import com.mmicu.demo.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityFeedBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_feed
        )

        val feedFragment = FeedFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, feedFragment).commit()
    }
}
