package com.example.appmovies.data

import com.example.appmovies.domain.Movie

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMovies(): List<Movie> = movieDataSource.getAllMovies()
}