package com.example.level6_task2.ui

import android.content.Intent
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
    private val movies = arrayListOf<Movie>()
    private val viewModel: MovieViewModel by viewModels()
    private val movieAdapter =
        MovieAdapter(movies) { movie ->
            onMovieClick(movie)
        }
    lateinit var layoutManager: LinearLayoutManager

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {movie ->
            movies.clear()
            movies.addAll(movie)
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

        rvMovies.layoutManager = GridLayoutManager(context, 2)
        rvMovies.adapter = movieAdapter

        observeMovies()
    }

    // Function to fetch movies from API
    private fun fetchMoviesByYear(){
        val year  = year.text.toString()
        if (year.isNotBlank()){
            val yearInt = year.toInt() // Convert year string to integer so it can be passed to getMovies method
            viewModel.getMovies(yearInt)
        } else {
            Toast.makeText(context, "Input is empty", LENGTH_LONG).show()
            Log.d("emptyInput", "Input is empty")
        }
    }

    // Click listener for specific movie
    private fun onMovieClick(movie: Movie) {
        // Open details activity of clicked movie and send movie so data of that movie can be displayed
        val intent = Intent(context, MovieDetailsActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }

}