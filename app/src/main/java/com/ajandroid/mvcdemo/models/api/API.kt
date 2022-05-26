package com.ajandroid.mvcdemo.models.api

import com.ajandroid.mvcdemo.BuildConfig
import com.ajandroid.mvcdemo.models.models.MoviesList
import retrofit2.Call

class API constructor(
    private val retrofitService: RetrofitService
) {

    fun getAllMovies(): Call<MoviesList> = retrofitService.getPopularMovies(BuildConfig.API_KEY)

}