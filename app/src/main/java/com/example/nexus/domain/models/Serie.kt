package com.example.nexus.domain.models

data class Serie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val voteAverage: Double,
    val firstAirDate: String
)