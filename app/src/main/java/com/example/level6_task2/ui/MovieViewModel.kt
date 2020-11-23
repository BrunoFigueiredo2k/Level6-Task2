package com.example.level6_task2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.level6_task2.ui.data.Movie

class MovieViewModel : ViewModel(){
    private val colorRepository = MovieRepository()

    //use encapsulation to expose as LiveData
    val movieItem: LiveData<List<Movie>>
        get() = _movieItems

    private val _movieItems = MutableLiveData<List<Movie>>().apply {
        value = colorRepository.getColorItems()
    }
}
