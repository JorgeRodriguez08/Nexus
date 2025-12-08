package com.example.nexus.domain.models

data class MovieDetails(
    val movie: Movie,
    val cast: List<Actor>,
    val crew: List<Producer>,
    val imageMovie: ImageMovie
)
