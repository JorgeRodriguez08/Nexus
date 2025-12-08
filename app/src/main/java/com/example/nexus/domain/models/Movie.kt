package com.example.nexus.domain.models

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val posterUrl: String,
    val backdropUrl: String,
    val voteAverage: Double,
    val releaseDate: String,
    val runtime: Int
)