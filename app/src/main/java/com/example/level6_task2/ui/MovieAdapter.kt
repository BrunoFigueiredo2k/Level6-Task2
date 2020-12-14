package com.example.level6_task2.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.level6_task2.R
import com.example.level6_task2.model.ResultSetWithMovies
import com.example.level6_task2.ui.data.Movie
import kotlinx.android.synthetic.main.activity_movie_details.view.*
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies: MutableList<ResultSetWithMovies>, private val onClick: (ResultSetWithMovies) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(movies[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }
        @SuppressLint("SetTextI18n")
        fun databind(movie: ResultSetWithMovies, position: Int) {
//            itemView.poster_movie.setImageResource(movies[position])
            itemView.number_movie.text = (position + 1).toString()
            Glide.with(context).load(movie.getImageUrl(position)).into(itemView.poster_movie)
        }

    }

}