package com.example.mytextbook.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytextbook.R
import com.example.mytextbook.model.Product

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList =
        for (i in 1..5) {
            val name = "Item $i"
            val price = "price $i"
            val product = Product(name, price)
            productList.add()
        }
    }
}