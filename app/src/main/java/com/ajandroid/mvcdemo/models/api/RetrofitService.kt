package com.ajandroid.mvcdemo.models.api


import com.ajandroid.mvcdemo.BuildConfig
import com.ajandroid.mvcdemo.models.models.MoviesList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") api_key:String): Call<MoviesList>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                                .baseUrl(BuildConfig.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!

        }
    }

}