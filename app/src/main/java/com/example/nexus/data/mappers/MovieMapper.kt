package com.example.nexus.data.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.domain.model.Movie

fun MovieDto.toDomainMovie(): Movie {
    val posterUrl = if (!posterPath.isNullOrEmpty()) {
        "${BuildConfig.TMDB_IMAGE_BASE_URL}${posterPath}"
    } else {
        ""
    }

    val backdropUrl = if (!backdropPath.isNullOrEmpty()) {
        "${BuildConfig.TMDB_IMAGE_BASE_URL}${backdropPath}"
    } else {
        ""
    }

    return Movie(
        id = id,
        title = title ?: "Unknown title",
        overview = overview ?: "No overview available",
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        voteAverage = voteAverage ?: 0.0,
        releaseDate = releaseDate ?: "Unknown Date"
    )
}