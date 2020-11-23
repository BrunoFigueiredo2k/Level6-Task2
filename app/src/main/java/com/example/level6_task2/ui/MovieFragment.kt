package com.example.level6_task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.level6_task2.R
import com.example.level6_task2.ui.data.Movie
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieFragment : Fragment() {
    private val colors = arrayListOf<Movie>()
    private lateinit var colorAdapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    private fun observeColors() {
        viewModel.movieItem.observe(viewLifecycleOwner, Observer {
            colors.clear()
            colors.addAll(it)
            colorAdapter.notifyDataSetChanged()
        })
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorAdapter = MovieAdapter(colors)
        rvColors.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvColors.adapter = colorAdapter

        observeColors()
    }

//    private fun onColorClick(colorItem: Movie) {
//        Snackbar.make(rvColors, "This color is: ${colorItem.name}", Snackbar.LENGTH_LONG).show()
//    }

}