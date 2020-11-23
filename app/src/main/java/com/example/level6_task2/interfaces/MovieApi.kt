package com.example.level6_task2.interfaces

import com.example.level6_task2.ui.data.Movie
import retrofit2.http.GET

interface MovieApi {

    // The GET method needed to retrieve our movie data
    @GET("/random/trivia?json")
    suspend fun getRandomNumberTrivia(): Movie
}