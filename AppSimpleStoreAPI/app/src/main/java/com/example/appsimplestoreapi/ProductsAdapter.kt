package com.example.appsimplestoreapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appsimplestoreapi.databinding.RecyclerViewItemBinding

class ProductsAdapter(
    private val context: Context,
    private val productList: List<Product>
): RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>(){

    inner class ProductViewHolder(val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.productName.text = productList[position].prName
        holder.binding.productPrice.text = productList[position].prPrice
        holder.binding.productDescription.text = productList[position].prDescription
        //load image
        //Glide.with(context).load(holder.binding.productImage).into(holder.binding.productImage)
    }

    override fun getItemCount(): Int = productList.size


}