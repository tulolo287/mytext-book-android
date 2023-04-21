package com.example.mytextbook.adapters

import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytextbook.Activity.ProductDetail
import com.example.mytextbook.R
import com.example.mytextbook.model.Product

class ProductAdapter(private val data: MutableList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
val productName: TextView
val price: TextView
val img: ImageView
    init {
        productName = view.findViewById(R.id.tv_productName)
        price = view.findViewById(R.id.tv_productPrice)
        img = view.findViewById(R.id.img_Product)
    }
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_recycler, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.price.text = item.name
        holder.price.text = item.price
        Glide.with(holder.itemView.context).load("https://goo.gl/gEgYUd").into(holder.img)

        holder.img.setOnClickListener(View.OnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context, ProductDetail::class.java))
        })

    }


}