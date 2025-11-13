package com.example.nexus.domain.model

data class MovieDetail(
    val movie: Movie,
    val image: ImageMovie?,
    val video: VideoMovie?
)