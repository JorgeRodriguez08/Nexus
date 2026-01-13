package com.example.nexus.domain.model

data class SeasonDetails(
    val airDate: String,
    val episodes: List<Episode>,
    val id: Int,
    val name: String,
    val overview: String,
    val posterUrl: String,
    val seasonNumber: Int
)
