package com.example.level6_task2.interfaces

import android.content.res.Resources
import com.example.level6_task2.R
import com.example.level6_task2.model.ResultSetWithMovies
import com.example.level6_task2.ui.data.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    // The GET method needed to retrieve our movie data
    @GET("3/discover/movie?api_key=da007e76d36aca68e174f2948e09389c&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    suspend fun fetchAllMovies(
        @Query("release_date") releaseYear: String
    ): ResultSetWithMovies


}