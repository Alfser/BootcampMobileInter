package com.example.appmovies.usecases

import com.example.appmovies.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMovies()
}