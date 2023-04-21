package com.example.mytextbook.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mytextbook.R
import com.example.mytextbook.helpers.ManagmentCart
import com.example.mytextbook.model.Product
import java.io.Serializable
import java.util.ResourceBundle.getBundle

class ProductDetail: AppCompatActivity() {
    lateinit var plusBtn: ImageView
    lateinit var minusBtn: ImageView
    lateinit var productImg: ImageView
    lateinit var addToCart: ImageView
    lateinit var productName: TextView
    lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.product_detail)
        //managmentCart = ManagmentCart(this )


    }

    private fun getBundle() {
        val product =  intent.getSerializableExtra("product") as Product
        val resourceId = this.resources.getIdentifier("image1", "drawable", this.packageName)
       // Glide.with(this).load(resourceId).into(productImg)
        Glide.with(this).load("https://goo.gl/gEgYUd").into(productImg)
        productName.text = "product"

    }

    private fun initView() {
        productImg = findViewById(R.id.productPhoto)
        plusBtn = findViewById<ImageView>(R.id.plusBtn)
        minusBtn = findViewById<ImageView>(R.id.minusBtn)
        addToCart = findViewById(R.id.btn_addToCart)
        productName = findViewById(R.id.productName)
    }
}