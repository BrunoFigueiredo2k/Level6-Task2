package com.example.level6_task1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.level6_task1.ui.data.ColorItem

class ColorViewModel : ViewModel(){
    private val colorRepository = ColorRepository()

    //use encapsulation to expose as LiveData
    val colorItems: LiveData<List<ColorItem>>
        get() = _colorItems

    private val _colorItems = MutableLiveData<List<ColorItem>>().apply {
        value = colorRepository.getColorItems()
    }
}
