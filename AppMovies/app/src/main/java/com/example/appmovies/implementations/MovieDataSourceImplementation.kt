package com.example.appmovies.implementations

import android.util.Log
import com.example.appmovies.data.MovieRestApiTask
import com.example.appmovies.data.MovieDataSource
import com.example.appmovies.domain.Movie

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDataSource {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {

        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }
        }
        else{

            request?.errorBody().let {
                Log.d(TAG, it.toString())
            }
        }

        return movieList
    }
}