package com.example.level6_task2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.level6_task2.R
import com.example.level6_task2.ui.data.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.item_movie.*

class MovieDetailsActivity : AppCompatActivity() {
    val imageUrl : String = "https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // Get movie sent with intent from MovieFragment to this activity
        val movie = intent.getParcelableExtra<Movie>("movie")

        // Set images using glide and text of specific movie
        Glide.with(this).load(imageUrl + movie?.backdropImg).into(ivBackdropImg)
        Glide.with(this).load(imageUrl + movie?.posterImg).into(ivPosterImg)
        tvTitle.text = movie?.title
        tvReleaseDate.text = movie?.releaseDate
        tvRating.text = movie?.rating.toString()
        tvOverview.text = movie?.overview
    }
}