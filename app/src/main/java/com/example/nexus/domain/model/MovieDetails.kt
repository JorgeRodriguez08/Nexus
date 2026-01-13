package com.example.nexus.domain.model

data class MovieDetails(
    val movie: Movie,
    val logo: ImageMovie?,
    val cast: List<Actor> = emptyList(),
    val crew: List<Producer> = emptyList()
)