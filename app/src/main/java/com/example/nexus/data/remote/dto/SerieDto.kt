package com.example.nexus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SerieDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("first_air_date")
    val firstAirDate: String?
)