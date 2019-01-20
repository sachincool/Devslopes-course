package com.crappy.dinnerdecider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
val foodList= arrayListOf("Chinese","Hamburger","Pizza","McDonalds","Italian Pizza")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {
            val random= Random()
            val randomFood=random.nextInt(foodList.count())
            selectedFoodTxt.text=foodList.get(randomFood)
        }
        addFoodBtn.setOnClickListener {
            val newFood=addFoodTxt.text.toString()
            foodList.add(newFood)
            addFoodTxt.text.clear()
        }
    }


}
