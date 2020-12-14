package com.example.level6_task2.ui.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("backdrop_path")
    var backdropImg: String,

    @SerializedName("poster_path")
    var posterImg: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("vote_average")
    var rating: Float,

    @SerializedName("overview")
    var overview: String
)