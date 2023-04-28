package com.example.mytextbook.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytextbook.R
import com.example.mytextbook.adapters.CartAdapter
import com.example.mytextbook.helpers.ManagmentCart
import com.example.mytextbook.interfaces.ChangeNumberItemsListener

class CartActivity : AppCompatActivity() {

    private lateinit var managmentCart: ManagmentCart
    lateinit var total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        total = findViewById(R.id.total)

        managmentCart = ManagmentCart(this)

        calculateCart()

        val recycle: RecyclerView = findViewById(R.id.cart_recycler)
        recycle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle.adapter = CartAdapter(managmentCart.getListCart(), managmentCart,
            object : ChangeNumberItemsListener {
                override fun changed() {
                    calculateCart()
                }
            })

    }

    fun calculateCart() {
        total.text = managmentCart.getTotal().toString()
    }
}