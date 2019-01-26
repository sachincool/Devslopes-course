package com.crappy.swoosh

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        get_started_btn.setOnClickListener {
            val leagueIntent=Intent(this,leagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}
