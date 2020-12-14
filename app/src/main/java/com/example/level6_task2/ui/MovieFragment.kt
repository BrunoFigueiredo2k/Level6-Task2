package com.example.level6_task2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.level6_task2.R
import com.example.level6_task2.interfaces.MovieApiService
import com.example.level6_task2.model.ResultSetWithMovies
import com.example.level6_task2.ui.data.Movie
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private val movies = arrayListOf<ResultSetWithMovies>()
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter
    lateinit var layoutManager: LinearLayoutManager

    private fun observeMovies() {
        viewModel.movie.observe(viewLifecycleOwner, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Submit button click list movies recyclerview
        btn_submit.setOnClickListener{
            fetchMoviesByYear()
        }

        movieAdapter = MovieAdapter(movies, ::onMovieClick)
        rvMovies.layoutManager = GridLayoutManager(context, 2)
        rvMovies.adapter = movieAdapter

        observeMovies()
    }

    // Function to fetch movies from API
    private fun fetchMoviesByYear(){
        if (year.text.toString().isNotBlank()){
            viewModel.getMovies()
            Log.d("movies", viewModel.getMovies().toString())
        } else {
            Toast.makeText(context, "Input is empty", LENGTH_LONG).show()
            Log.d("emptyInput", "Input is empty")
        }
    }

    // Click listener for specific movie
    // TODO: add open movie specific page onclick that movie
    private fun onMovieClick(movie: ResultSetWithMovies) {
        // TODO: fix this to display clicked movie and not all movies (index of array)
        Snackbar.make(rvMovies, "Clicked movie title: ${movie.movies[0].title}", Snackbar.LENGTH_LONG).show()
        Log.d("movieObject", "Movie object: ${movie.movies}")
    }

}