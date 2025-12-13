package com.example.nexus.domain.model

data class SerieDetails(
    val serie: Serie,
    val cast: List<Actor>,
    val crew: List<Producer>
)
