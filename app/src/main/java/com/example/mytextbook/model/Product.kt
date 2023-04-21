package com.example.mytextbook.model

import android.os.Parcelable

data class Product(val name: String, val description: String, val price: String, val img: String, var numberInCart: Int): java.io.Serializable
