package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class MovieDto(
    val id: Int,
    @SerializedName("title")
    val title: String?,
    val overview: String?,
    val adult: Boolean?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("release_date")
    val releaseDate: String?
)