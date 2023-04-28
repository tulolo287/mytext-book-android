package com.example.mytextbook.adapters

import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytextbook.Activity.MainActivity
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
        holder.price.text = item.price.toString()
        val imgId = holder.itemView.context.resources.getIdentifier(item.img, "drawable", holder.itemView.context.packageName)
        Glide.with(holder.itemView.context).load(imgId).into(holder.img)

        holder.img.setOnClickListener(View.OnClickListener {
            //Toast.makeText(holder.itemView.context, "KJJLJ", Toast.LENGTH_LONG).show()
            startActivity(holder.itemView.context, Intent(holder.itemView.context, ProductDetail::class.java).apply {
                putExtra("product", item)
            }, null)
        })

    }


}