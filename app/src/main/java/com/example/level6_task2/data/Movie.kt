package com.example.level6_task2.ui.data

import java.util.*

data class Movie(
    var backdropImg: String,
    var posterImg: String,
    var title: String,
    var releaseDate: Date,
    var rating: Int,
    var overview: String
) {
    var apiKey: String = "da007e76d36aca68e174f2948e09389c"
    //TODO: change function name to getMovie()
    fun getImageUrl() = "https://api.themoviedb.org/3/discover/movie?api_key=$apiKey&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1"
}

