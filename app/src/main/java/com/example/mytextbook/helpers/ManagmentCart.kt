package com.example.mytextbook.helpers

import android.content.Context
import android.widget.Toast
import com.example.mytextbook.Activity.MainActivity
import com.example.mytextbook.interfaces.ChangeNumberItemsListener
import com.example.mytextbook.model.Product

class ManagmentCart(context: Context) {
    lateinit var tinyDB: TinyDB
    lateinit var context: Context
    init {
        this.tinyDB = TinyDB(context)
        this.context = context
    }

    fun insertProduct(item: Product) {
        val items: ArrayList<Product> = getListCart()
            // var exist: Boolean = false
       // for (i in 0 until items.size) {
         //   if (items[i].name === item.name) {
          //      items[i].numberInCart = item.numberInCart
          //  } else {
                items.add(item)
        //    }
            tinyDB.putListObject("CartList", items)
            Toast.makeText(context, "Added item to cart", Toast.LENGTH_LONG).show()

       // }

    }

    fun getListCart():ArrayList<Product> {
        return tinyDB.getListObject("CartList")
    }

    fun plusNumberProduct(products: ArrayList<Product>, position: Int, changeNumberItemsListener: ChangeNumberItemsListener) {
        val item = products[position]
        item.numberInCart = item.numberInCart++
        tinyDB.putListObject("CartList", products)
        changeNumberItemsListener.changed()

    }

    fun minusNumberProduct(products: ArrayList<Product>, position: Int, changeNumberItemsListener: ChangeNumberItemsListener) {
        val item = products[position]
        if (item.numberInCart === 1) {
            products.remove(item)
        } else {
            item.numberInCart = item.numberInCart--
        }

        tinyDB.putListObject("CartList", products)
        changeNumberItemsListener.changed()

    }

    fun getTotal(): Int {
        return 234
    }
}