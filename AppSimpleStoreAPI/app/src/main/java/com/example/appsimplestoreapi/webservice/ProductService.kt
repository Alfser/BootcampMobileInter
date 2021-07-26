package com.example.appsimplestoreapi.webservice

import com.example.appsimplestoreapi.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getProducts(): Call<List<Product>>
}