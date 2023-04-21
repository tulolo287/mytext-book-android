package com.example.mytextbook.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
            Product("kjl", "lkjl", "342rub", "image1", 0),
            Product("kjl", "lkjl", "342rub", "image1", 0),
            Product("kjl", "lkjl", "342rub", "image1", 0),
            Product("kjl", "lkjl", "342rub", "image1", 0),
            Product("kjl", "lkjl", "342rub", "image1", 0),
            Product("kjl", "lkjl", "342rub", "image1", 0),
        )

        val resView = findViewById<RecyclerView>(R.id.res2)
        resView.layoutManager = GridLayoutManager(this, 2 )
        resView.adapter =  ProductAdapter(products)
    }


}