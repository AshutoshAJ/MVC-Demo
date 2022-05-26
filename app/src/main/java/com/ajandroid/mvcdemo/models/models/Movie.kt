package com.ajandroid.mvcdemo.models.models


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("title")
    val title: String?,
)