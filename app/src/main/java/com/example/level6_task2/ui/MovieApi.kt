package com.example.level6_task2.ui

import android.util.Log
import com.example.level6_task2.interfaces.MovieApiService
import com.example.level6_task2.ui.data.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {
    companion object {
        // The base url off the api.
        private const val baseUrl = "http://numbersapi.com/"

        /** @return [TriviaApiService] The service class off the retrofit client.*/
        fun createApi(): MovieApiService {
            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create the Retrofit instance
            val movieApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit TriviaApiService
            return movieApi.create(MovieApiService::class.java)
        }
    }
}