package com.example.mytextbook.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytextbook.R

class ProductAdapter(private val dataSet: Array<String>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_cardName: TextView
        val tv_cardPrice: TextView
        val img_cardImg: ImageView

        init {
            tv_cardName = view.findViewById(R.id.tv_cardName)
            tv_cardPrice = view.findViewById(R.id.tv_cardPrice)
            img_cardImg = view.findViewById(R.id.img_cardProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_cardPrice.text = dataSet[position].price
        holder.tv_cardName.text = dataSet[position].name
        //holder.img_cardImg.setImageBitmap()
    }
}