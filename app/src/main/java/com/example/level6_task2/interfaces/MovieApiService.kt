package com.example.level6_task2.interfaces

import android.content.res.Resources
import com.example.level6_task2.R
import com.example.level6_task2.ui.data.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiService {

    // The GET method needed to retrieve our movie data
    @GET("/movie")
    suspend fun fetchAllMovies(): Movie
}