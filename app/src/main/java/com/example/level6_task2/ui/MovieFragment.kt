package com.example.level6_task2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.level6_task2.R
import com.example.level6_task2.interfaces.MovieApiService
import com.example.level6_task2.ui.data.Movie
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        movieAdapter = MovieAdapter(movies)
        rvMovies.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvMovies.adapter = movieAdapter

        observeMovies()
    }

//    private fun onColorClick(colorItem: Movie) {
//        Snackbar.make(rvmovies, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG).show()
//    }

}