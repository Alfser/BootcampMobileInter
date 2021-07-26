package com.example.appsimplestoreapi.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {

    private val retrofit: Retrofit

    fun productService(): ProductService{
        return retrofit.create(ProductService::class.java)
    }

    companion object{
        private const val BASE_URL =
            "http://localhost:3000/"


        private val myRetrofit: MyRetrofit? = null
        @get:Synchronized
        val instance: MyRetrofit?
            get() = myRetrofit ?: MyRetrofit()
    }

    init {
        retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}