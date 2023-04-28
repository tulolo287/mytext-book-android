package com.example.mytextbook.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytextbook.R
import com.example.mytextbook.helpers.ManagmentCart
import com.example.mytextbook.interfaces.ChangeNumberItemsListener
import com.example.mytextbook.model.Product

class CartAdapter(val products: ArrayList<Product>, val managmentCart: ManagmentCart, val changeNumberItemsListener: ChangeNumberItemsListener): RecyclerView.Adapter<CartAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var qty: TextView
        var name: TextView
        var imgProductCart: ImageView
        var total: ImageView
        var plusQty: Button
        var minusQty: Button

        init {
            plusQty = view.findViewById(R.id.btn_plus)
            minusQty = view.findViewById(R.id.btn_minus)
            qty = view.findViewById(R.id.qtyCart)
            name = view.findViewById(R.id.nameCartItem)
            imgProductCart = view.findViewById(R.id.img_productCart)
            total = view.findViewById(R.id.total_int)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = products[position]
        holder.qty.text = item.numberInCart.toString()
        holder.name.text = item.name.toString()

        holder.plusQty.setOnClickListener(View.OnClickListener {
            managmentCart.plusNumberProduct(products, position, changeNumberItemsListener)
        })
        holder.minusQty.setOnClickListener(View.OnClickListener {
            managmentCart.minusNumberProduct(products, position, changeNumberItemsListener)
        })

        val imgId = holder.itemView.context.resources.getIdentifier(item.img, "drawable", holder.itemView.context.packageName)
        Glide.with(holder.itemView.context).load(imgId).into(holder.imgProductCart)

    }
}