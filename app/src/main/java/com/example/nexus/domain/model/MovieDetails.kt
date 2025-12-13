package com.example.nexus.domain.model

data class MovieDetails(
    val movie: Movie,
    val image: ImageMovie,
    val cast: List<Actor>,
    val crew: List<Producer>
)