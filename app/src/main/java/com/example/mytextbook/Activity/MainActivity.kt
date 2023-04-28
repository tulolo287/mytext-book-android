package com.example.mytextbook.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytextbook.R
import com.example.mytextbook.adapters.CategoryAdapter
import com.example.mytextbook.adapters.ProductAdapter
import com.example.mytextbook.model.Category
import com.example.mytextbook.model.Product
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var products: MutableList<Product>
    lateinit var cart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // cart = findViewById<Button>(/* id = */ R.id.cart)

        var images = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5)
        val categoryList = mutableListOf<Category>()
        for (i in 0..4) {
            val name = "Item $i"
            val price = "price $i"
            val img = "image$i"
            val category = Category(name, price, images[i])
            categoryList.add(category)
        }

        val recyclerView: RecyclerView = findViewById(R.id.res1)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = CategoryAdapter(this@MainActivity, categoryList)

        recyclerProduct()



    }

    private fun recyclerProduct() {
        products = mutableListOf<Product>(
            Product("kcxvzxczrejl", "sfda", 44, "image1", 0),
            Product("kjcl", "dasfsdfds", 432, "image2", 0),
            Product("kcvcjl", "lxczvxczvxczxczkjl", 34, "image3", 0),
            Product("kxcvjl", "zxcv", 3467, "image4", 0),
            Product("vasdfdasfdxz", "xczvzxcxczv", 87, "image5", 0),
            Product("kjdsafl", "lkxczvxcvc c v zs vdfs zxcvjl", 367, "image6", 0),
        )

        val resView = findViewById<RecyclerView>(R.id.res2)
        resView.layoutManager = GridLayoutManager(this, 2 )
        resView.adapter =  ProductAdapter(products)
    }

    fun goToCart(view: View) {

        startActivity(Intent(this, CartActivity::class.java))
        //Toast.makeText(this, "sdfdadfas", Toast.LENGTH_LONG).show()
    }


}