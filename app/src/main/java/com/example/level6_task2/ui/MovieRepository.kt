package com.example.level6_task2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level6_task2.interfaces.MovieApiService
import com.example.level6_task2.ui.data.Movie
import kotlinx.coroutines.withTimeout

class MovieRepository {
    private val triviaApiService: MovieApiService = MovieApi.createApi()

    private val _movie: MutableLiveData<Movie> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val movie: LiveData<Movie>
        get() = _movie

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun getMovieItems()  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                triviaApiService.fetchAllMovies()
            }

            _movie.value = result
        } catch (error: Throwable) {
            throw TriviaRefreshError("Unable to refresh trivia", error)
        }
    }

    class TriviaRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}
