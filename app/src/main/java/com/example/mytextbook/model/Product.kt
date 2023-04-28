package com.example.mytextbook.model

import android.os.Parcelable

data class Product(val name: String, val description: String, val price: Int, val img: String, var numberInCart: Int = 1): java.io.Serializable
