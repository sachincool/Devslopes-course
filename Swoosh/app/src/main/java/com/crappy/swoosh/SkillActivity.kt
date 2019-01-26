package com.crappy.swoosh

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.crappy.swoosh.model.player
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    lateinit var Player:player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        Player=intent.getParcelableExtra("player")

        skillFinish.setOnClickListener {
            if (Player.skill.isNotEmpty()) {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra("player", Player)
                startActivity(finishActivity)

            } else
                Toast.makeText(this, "Please Select a Skill", Toast.LENGTH_SHORT).show()
        }
        ballerbtn.setOnClickListener {
            beginnerbtn.isChecked=false
            Player.skill="baller"
        }
        beginnerbtn.setOnClickListener {
            ballerbtn.isChecked=false
            Player.skill="beginner"
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putParcelable("player",Player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState!=null)
            Player=savedInstanceState.getParcelable("player")!!
    }
}
