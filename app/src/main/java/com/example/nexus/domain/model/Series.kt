package com.example.nexus.domain.model

data class Series(
    val id: Int,
    val name: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val voteAverage: Double,
    val firstAirDate: String
)