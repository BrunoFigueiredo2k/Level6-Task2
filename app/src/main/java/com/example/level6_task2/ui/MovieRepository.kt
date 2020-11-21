package com.example.level6_task2.ui

import com.example.level6_task2.ui.data.Movie

class MovieRepository {
    fun getColorItems(): List<Movie> {
        return arrayListOf(
            Movie("000000", "Black"),
            Movie("FF0000", "Red"),
            Movie("0000FF", "Blue"),
            Movie("FFFF00", "Yellow"),
            Movie("008000", "Green")
        )
    }
}
