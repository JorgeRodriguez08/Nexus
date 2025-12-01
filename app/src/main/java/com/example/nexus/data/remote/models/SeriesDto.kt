package com.example.nexus.data.remote.models

import com.google.gson.annotations.SerializedName

data class SeriesDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String?,
    @SerializedName("overview")
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