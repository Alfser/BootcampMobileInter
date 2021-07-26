package com.example.appmovies.mainmovielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.appmovies.R
import com.example.appmovies.databinding.RecyclerViewItemBinding
import com.example.appmovies.domain.Movie

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private var movies: List<Movie> = listOf()

    inner class MovieViewHolder(
        val binding: RecyclerViewItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.tvTitleVideo.text = movies[position].title
        holder.binding.imageVideo.load(movies[position].image){
            placeholder(R.drawable.ic_image_default)
            fallback(R.drawable.ic_image_default)
            error(R.drawable.ic_image_error)
        }
    }

    override fun getItemCount(): Int = movies.size

    fun setMovieList(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}