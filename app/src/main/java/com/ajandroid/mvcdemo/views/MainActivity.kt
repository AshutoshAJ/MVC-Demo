package com.ajandroid.mvcdemo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajandroid.mvcdemo.controllers.MainActivityController
import com.ajandroid.mvcdemo.controllers.MoviesFetchListener
import com.ajandroid.mvcdemo.databinding.ActivityMainBinding
import com.ajandroid.mvcdemo.models.api.API
import com.ajandroid.mvcdemo.models.api.RetrofitService
import com.ajandroid.mvcdemo.models.models.Movie
import com.ajandroid.mvcdemo.views.adapters.MovieAdapter

class MainActivity : AppCompatActivity(), MoviesFetchListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofitService: RetrofitService
    private lateinit var adapter: MovieAdapter
    private lateinit var mainActivityController: MainActivityController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = RetrofitService.getInstance()
        mainActivityController = MainActivityController(API(retrofitService), this)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        adapter = MovieAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    override fun onFetched(moviesList: List<Movie>) {
        adapter.setList(moviesList)
        adapter.notifyDataSetChanged()
        binding.progressBar.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        mainActivityController.getAllMovies()
        binding.progressBar.visibility = View.VISIBLE
    }
}