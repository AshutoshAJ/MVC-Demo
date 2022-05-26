package com.ajandroid.mvcdemo.controllers

import com.ajandroid.mvcdemo.models.api.API
import com.ajandroid.mvcdemo.models.models.MoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityController(
    private val api: API,
    private val moviesFetchListener: MoviesFetchListener
) {

    fun getAllMovies() {

        val response = api.getAllMovies()
        response.enqueue(object : Callback<MoviesList> {
            override fun onResponse(
                call: Call<MoviesList>,
                response: Response<MoviesList>
            ) {
                moviesFetchListener.onFetched(response.body()?.movies!!)
            }

            override fun onFailure(call: Call<MoviesList>, t: Throwable) {

            }


        })

    }

}