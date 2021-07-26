package com.example.appmovies.data

import com.example.appmovies.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>
}