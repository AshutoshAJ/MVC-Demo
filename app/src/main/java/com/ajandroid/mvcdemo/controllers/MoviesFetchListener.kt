package com.ajandroid.mvcdemo.controllers

import com.ajandroid.mvcdemo.models.models.Movie

interface MoviesFetchListener {

    fun onFetched(moviesList: List<Movie>)

}