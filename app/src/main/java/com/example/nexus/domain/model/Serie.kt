package com.example.nexus.domain.model

data class Serie(
    val id: Int,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val posterUrl: String,
    val backdropUrl: String,
    val voteAverage: Double,
    val firstAirDate: String
)