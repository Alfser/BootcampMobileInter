package com.example.appmovies.domain

import com.google.gson.annotations.SerializedName
import java.sql.Date


data class Movie(
    @SerializedName("id") val id: Long,
    @SerializedName("titulo") val title: String,
    @SerializedName("descricao") val description: String? = null,
    @SerializedName("imagem") val image: String? = null,
    val date: Date? = null
)
