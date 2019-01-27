package com.crappy.coderswag.Adapers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crappy.coderswag.Model.Product
import com.crappy.coderswag.R
import kotlinx.android.synthetic.main.product_item_view.view.*

class ProductAdapter(val context: Context,val products:List<Product>) : RecyclerView.Adapter<ProductAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductAdapter.Holder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.product_item_view,p0,false)

    return  Holder(view)
    }

    override fun getItemCount(): Int {
    return products.count()
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bindProduct(products[p1],context)

        }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage=itemView.productImage
        val productName=itemView.productName
        val productPrice=itemView.productPrice
        fun bindProduct(product:Product,context:Context){
            val resId=context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage.setImageResource(resId)
            productName.text=product.title
            productPrice.text=product.price
        }
    }

}