package com.example.appmovies.mainmovielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmovies.databinding.ActivityMainBinding
import com.example.appmovies.domain.Movie


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initRecyclerMovieList()
    }

    private fun initObserver(){
        movieListViewModel.movieList.observe(this){ movies ->
            initMovieList(movies)
        }
    }

    private fun initMovieList(movies: List<Movie>) {
        adapter.setMovieList(movies)
    }

    private fun initRecyclerMovieList() {

        binding.recyclerMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this@MainActivity.adapter = MovieAdapter()
            adapter = this@MainActivity.adapter
        }

        //ini an observer of recyclerView item list
        initObserver()
    }
}