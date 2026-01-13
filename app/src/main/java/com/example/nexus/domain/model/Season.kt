package com.example.nexus.domain.model

data class Season(
    val airDate: String,
    val episodeCount: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val posterUrl: String,
    val seasonNumber: Int
)