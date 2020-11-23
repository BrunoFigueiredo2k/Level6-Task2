package com.example.level6_task2.ui.data

import android.content.res.Resources
import com.example.level6_task2.R
import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("backdropImg") var backdropImg: Int,
    @SerializedName("posterImg") var posterImg: Int,
    @SerializedName("title") var title: String,
    @SerializedName("releaseDate") var releaseDate: Date,
    @SerializedName("rating") var rating: Int,
    @SerializedName("overview") var overview: String
) {
    var apiKey: String = Resources.getSystem().getString(R.string.api_key);
    //TODO: change function name to getMovie()
    fun getImageUrl() = "https://api.themoviedb.org/3/discover/movie?api_key=$apiKey&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1"
}

