package com.example.mytextbook.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mytextbook.R
import com.example.mytextbook.model.Category

class CategoryAdapter(private val context: Context, private val dataSet: MutableList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_cardName: TextView
        val img_cardImg: ImageView
        val productLayout: LinearLayout

        init {
            productLayout = view.findViewById(R.id.category_layout)
            tv_cardName = view.findViewById(R.id.tv_categoryName)
            img_cardImg = view.findViewById(R.id.img_cardProduct) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        var requestOptions = RequestOptions()

        when(position) {
            0 -> holder.productLayout.setBackgroundColor(Color.BLUE)
            1 -> holder.productLayout.setBackgroundColor(Color.RED)
        }

        holder.tv_cardName.text = item.name.toString()
        val id = holder.itemView.context.resources.getIdentifier("image1", "drawable", holder.itemView.context.packageName)
        Glide.with(context).load("https://goo.gl/gEgYUd").error(R.drawable.baseline_search_24).into(holder.img_cardImg)
       // holder.img_cardImg.setImageResource(item.imageId)
        //holder.img_cardImg.setImageBitmap()
    }
}