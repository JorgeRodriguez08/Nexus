package com.example.nexus.domain.model

data class MovieDetail(
    val movie: Movie,
    val video: VideoMovie?,
    val cast: List<Actor>,
    val crew: List<Producer>
)
