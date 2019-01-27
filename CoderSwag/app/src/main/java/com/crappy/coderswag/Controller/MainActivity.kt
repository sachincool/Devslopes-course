package com.crappy.coderswag.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.crappy.coderswag.Adapers.CategoryAdapter
import com.crappy.coderswag.R
import com.crappy.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var adapter:CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    adapter=CategoryAdapter(this,DataService.categories){
        category ->   val productIntent= Intent(this,ProductsActivity::class.java)
        productIntent.putExtra("category",category.title)

        startActivity(productIntent)
    }
        categoryListView.adapter=adapter
        val layoutManager=LinearLayoutManager(this)
        categoryListView.layoutManager=layoutManager
        categoryListView.setHasFixedSize(true)
    }
    }

