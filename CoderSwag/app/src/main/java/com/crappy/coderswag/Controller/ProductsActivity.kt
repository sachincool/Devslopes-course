package com.crappy.coderswag.Controller

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.crappy.coderswag.Adapers.ProductAdapter
import com.crappy.coderswag.R
import com.crappy.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
lateinit var adapter :ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType=intent.getStringExtra("category")
        adapter= ProductAdapter(this,DataService.getProducts(categoryType))
        val orientation =resources.configuration.orientation
        var spanCount=2
        if(orientation==Configuration.ORIENTATION_LANDSCAPE)
            spanCount=4
        val screensize=resources.configuration.screenWidthDp
        if (screensize>720)
            spanCount=3
        val layoutManager=GridLayoutManager(this,spanCount)
        productListView.layoutManager=layoutManager
        productListView.adapter=adapter


    }
}
