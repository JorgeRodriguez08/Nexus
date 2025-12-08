package com.example.nexus.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "series")
data class SeriesEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val voteAverage: Double,
    val firstAirDate: String,
    val timestamp: Long
) {
    constructor() : this(
        id = 0,
        name = "",
        overview = "",
        posterUrl = "",
        backdropUrl = "",
        voteAverage = 0.0,
        firstAirDate = "",
        timestamp = 0L
    )
}