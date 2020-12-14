package com.example.level6_task2.model

import com.example.level6_task2.ui.data.Movie
import com.google.gson.annotations.SerializedName

data class ResultSetWithMovies (
    @SerializedName("results") var movies: ArrayList<Movie>
) {
    // Function to get backdrop image file name
    fun getImageUrl(position: Int) = "https://image.tmdb.org/t/p/w500${movies[position].backdropImg}"
}
