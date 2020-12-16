package com.example.level6_task2.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.level6_task2.ui.data.Movie
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel(){
    private val movieRepository = MovieRepository()

    val movies = movieRepository.movie

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    fun getMovies(year: String) {
        viewModelScope.launch {
            try {
                movieRepository.getMovieItem(year)

            } catch (error: MovieRepository.MovieRefreshError) {
                _errorText.value = error.message
                Log.e("Movie error", error.cause.toString())
            }
        }
    }
}
