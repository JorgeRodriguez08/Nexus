package com.example.nexus.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val voteAverage: Double,
    val releaseDate: String,
    val timestamp: Long
) {
    constructor() : this(
        id = 0,
        title = "",
        overview = "",
        posterUrl = "",
        backdropUrl = "",
        voteAverage = 0.0,
        releaseDate = "",
        timestamp = 0L
    )
}