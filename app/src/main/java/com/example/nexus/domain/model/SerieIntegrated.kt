package com.example.nexus.domain.model

data class SerieIntegrated(
    val serieDetails: SerieDetails,
    val logo: ImageSerie?,
    val cast: List<Actor> = emptyList(),
    val crew: List<Producer> = emptyList()
)
