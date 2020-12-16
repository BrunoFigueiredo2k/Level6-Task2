package com.example.level6_task2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level6_task2.interfaces.MovieApiService
import com.example.level6_task2.model.ResultSetWithMovies
import com.example.level6_task2.ui.data.Movie
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    val movie: LiveData<ArrayList<Movie>>
        get() = _movies

    suspend fun getMovieItem(year: Int)  {
        try {
            //timeout the request after 5 seconds
            val result : ResultSetWithMovies = withTimeout(5_000) {
                movieApiService.fetchAllMovies(year)
            }

            _movies.value = result.movies
            Log.d("movies", result.toString())
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to refresh movies", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}
