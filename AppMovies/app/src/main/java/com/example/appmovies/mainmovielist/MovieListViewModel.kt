package com.example.appmovies.mainmovielist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmovies.data.MovieRepository
import com.example.appmovies.data.MovieRestApiTask
import com.example.appmovies.domain.Movie
import com.example.appmovies.implementations.MovieDataSourceImplementation
import com.example.appmovies.usecases.MovieListUseCase
import java.lang.Exception

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieLisViewModel"
    }

    private val movies = listOf(
        Movie(id = 0L, title = "Titanic"),
        Movie(id = 0L, title = "Independence Day"),
        Movie(id = 0L, title = "Arrival")
    )

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource: MovieDataSourceImplementation = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){

        Thread{
            try {
                _movieList.postValue(movieListUseCase.invoke())

            }catch (ex: Exception){
                Log.d(TAG, ex.message.toString())
            }

        }.start()
    }
}