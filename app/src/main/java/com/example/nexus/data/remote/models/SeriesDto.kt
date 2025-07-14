package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class SeriesDto(
    val id: Int,
    val title: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("first_air_date")
    val firstAirDate: String?
)