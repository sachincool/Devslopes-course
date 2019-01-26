package com.crappy.swoosh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.crappy.swoosh.model.player
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val Player=intent.getParcelableExtra<player>("player")
        searchleaguetxt.text="Looking for a ${Player.league} ${Player.skill} league near you..."

    }
}
