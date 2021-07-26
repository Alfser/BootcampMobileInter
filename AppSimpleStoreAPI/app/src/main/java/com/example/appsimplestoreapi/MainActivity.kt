package com.example.appsimplestoreapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsimplestoreapi.databinding.ActivityMainBinding
import com.example.appsimplestoreapi.webservice.MyRetrofit
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        getData()
    }

    private fun getData(){
        val call = MyRetrofit.instance?.productService()?.getProducts()

        call?.enqueue(object : retrofit2.Callback<List<Product>>{
            override fun onFailure(call: retrofit2.Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG)
            }

            override fun onResponse(
                call: retrofit2.Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                binding.recyclerMain.adapter =
                    ProductsAdapter(this@MainActivity, response.body()?.toList() ?: listOf())
            }
        })
    }
}