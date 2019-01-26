package com.crappy.swoosh

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.crappy.swoosh.model.player
import kotlinx.android.synthetic.main.activity_league.*

class leagueActivity : AppCompatActivity() {

    var Player= player("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    mensToggle.setOnClickListener {
        womenToggle.isChecked=false
        coedToggle.isChecked=false
        Player.league="mens"
    }
    womenToggle.setOnClickListener {
        mensToggle.isChecked=false
        coedToggle.isChecked=false
        Player.league="women"
    }
        coedToggle.setOnClickListener {
            mensToggle.isChecked=false
            womenToggle.isChecked=false
            Player.league="co-ed"
        }

    }
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable("player",Player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            Player=savedInstanceState.getParcelable("player")!!
        }
    }

    fun leagueNextClicked(view: View){
        if (Player.league.isNotEmpty()){
        val skillActivity= Intent(this,SkillActivity::class.java)
            skillActivity.putExtra("player",Player)
        startActivity(skillActivity)
        }
        else
            Toast.makeText(this,"Please select a league",Toast.LENGTH_SHORT).show()
    }




}
