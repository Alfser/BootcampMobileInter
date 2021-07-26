package com.example.appsimplestoreapi

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: String,
    @SerializedName("prname") val prName:String,
    @SerializedName("prprice") val prPrice: String,
    @SerializedName("prdescription") val prDescription: String
)
