package com.example.level6_task2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.level6_task2.ui.data.Movie

class ColorViewModel : ViewModel(){
    private val colorRepository = MovieRepository()

    //use encapsulation to expose as LiveData
    val colorItems: LiveData<List<Movie>>
        get() = _colorItems

    private val _colorItems = MutableLiveData<List<Movie>>().apply {
        value = colorRepository.getColorItems()
    }
}
