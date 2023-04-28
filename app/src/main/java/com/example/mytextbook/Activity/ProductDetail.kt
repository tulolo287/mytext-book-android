package com.example.mytextbook.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
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
    lateinit var addToCart: Button
    lateinit var productName: TextView
    lateinit var price: TextView
    lateinit var productDescription: TextView
    lateinit var qty: TextView
    lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)

        managmentCart = ManagmentCart(this )
        initView()
        getBundle()

    }

    private fun getBundle() {
        val product =  intent.getSerializableExtra("product") as Product
        val resourceId = this.resources.getIdentifier(product.img, "drawable", this.packageName)
       // Glide.with(this).load(resourceId).into(productImg)
        Glide.with(this).load(resourceId).into(productImg)
        productName.text = product.name
        productDescription.text = product.description

        plusBtn.setOnClickListener(View.OnClickListener {

            qty.text = product.numberInCart++.toString()
            price.text = (product.price * product.numberInCart).toString()
        })

        minusBtn.setOnClickListener(View.OnClickListener {
            if (product.numberInCart > 1) {
                qty.text = product.numberInCart--.toString()
            }
            price.text = (product.price * product.numberInCart).toString()

        })

        addToCart.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this, "Added to cart", Toast.LENGTH_LONG).show()
            product.numberInCart = 5
            managmentCart.insertProduct(product)
        })

    }

    private fun initView() {
        productImg = findViewById(R.id.productPhoto)
        plusBtn = findViewById<ImageView>(R.id.plusBtn)
        minusBtn = findViewById<ImageView>(R.id.minusBtn)
        addToCart = findViewById(R.id.btn_addToCart)
        price = findViewById(R.id.tv_price)
        productName = findViewById(R.id.productName)
        qty = findViewById(R.id.tv_qty)
        productDescription = findViewById(R.id.productDescription)
    }
}