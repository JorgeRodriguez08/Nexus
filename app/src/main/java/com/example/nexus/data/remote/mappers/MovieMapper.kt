package com.example.nexus.data.remote.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.MovieDto
import com.example.nexus.domain.model.Movie

fun MovieDto.toDomainMovie(): Movie {
    val finalTitle = if (title == null || title.isEmpty()) "Untitled" else title
    val finalOverview = if (overview == null || overview.isEmpty()) "No overview" else overview
    val finalAdult = adult ?: false
    val finalVoteAverage = voteAverage ?: 0.0
    val finalReleaseDate = releaseDate ?: "Unknown"
    val finalRuntime = runtime ?: 0

    var finalPosterUrl = ""
    if (posterPath != null && posterPath.isNotEmpty()) {
        finalPosterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + posterPath
    }

    var finalBackdropUrl = ""
    if (backdropPath != null && backdropPath.isNotEmpty()) {
        finalBackdropUrl = BuildConfig.TMDB_IMAGE_BASE_URL + backdropPath
    }

    return Movie(
        id = id,
        title = finalTitle,
        overview = finalOverview,
        adult = finalAdult,
        posterUrl = finalPosterUrl,
        backdropUrl = finalBackdropUrl,
        voteAverage = finalVoteAverage,
        releaseDate = finalReleaseDate,
        runtime = finalRuntime
    )
}
