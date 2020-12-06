package com.example.level6_task2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.view.isNotEmpty
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.level6_task2.R
import com.example.level6_task2.ui.data.Movie
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private val movies = arrayListOf<Movie>()
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    private fun observeMovies() {
//        viewModel.movieItem.observe(viewLifecycleOwner, Observer {
//            movies.clear()
//            movies.addAll(it)
//            movieAdapter.notifyDataSetChanged()
//        })
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

        movieAdapter = MovieAdapter(movies)
        rvMovies.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvMovies.adapter = movieAdapter

        observeMovies()
    }

    // Function to fetch movies from API
    private fun fetchMoviesByYear(){
        if (year.text.toString().isNotBlank()){
            viewModel.getMovies()
        } else {
            Toast.makeText(context, "Input is empty", LENGTH_LONG).show()
            Log.d("emptyInput", "Input is empty")
        }
    }

//    private fun onColorClick(colorItem: Movie) {
//        Snackbar.make(rvmovies, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG).show()
//    }

}