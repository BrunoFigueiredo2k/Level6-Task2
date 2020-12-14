package com.example.level6_task2.ui

import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level6_task2.interfaces.MovieApiService
import com.example.level6_task2.model.ResultSetWithMovies
import com.example.level6_task2.ui.data.Movie
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val movieApiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<List<ResultSetWithMovies>> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val movie: LiveData<List<ResultSetWithMovies>>
        get() = _movies

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun getMovieItems()  {
        try {
            //timeout the request after 5 seconds
            val result : ResultSetWithMovies = withTimeout(5_000) {
                movieApiService.fetchAllMovies()
            }

            _movies.value = listOf(result)
            Log.d("movies", result.toString())
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to refresh movies", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}
