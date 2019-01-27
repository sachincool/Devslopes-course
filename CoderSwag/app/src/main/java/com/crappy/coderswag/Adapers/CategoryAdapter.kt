package com.crappy.coderswag.Adapers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crappy.coderswag.Model.Category
import com.crappy.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter(val context: Context, val categories: List<Category>,val itemClick:(Category)-> Unit):
    RecyclerView.Adapter<CategoryAdapter.Holder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.category_list_item,p0,false)
        return Holder(view,itemClick)
    }


    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
    p0.bindCategory(categories[p1],context)
    }

    inner class Holder(itemView: View,val itemClick:(Category)->Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.categoryImage
        val categoryName = itemView.categoryName

        fun bindCategory(category: Category, context: Context) {
            val resourceId=context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text=category.title
            itemView.setOnClickListener{itemClick(category)}
        }
    }
}