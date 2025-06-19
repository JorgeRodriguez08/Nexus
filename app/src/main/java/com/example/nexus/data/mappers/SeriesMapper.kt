package com.example.nexus.data.mappers

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.models.SeriesDto
import com.example.nexus.domain.model.Series

fun SeriesDto.toDomainSeries(): Series {

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

    return Series(
        id = id,
        name = name ?: "Unknown Name",
        overview = overview ?: "No overview available",
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        voteAverage = voteAverage ?: 0.0,
        firstAirDate = firstAirDate ?: "Unknown Date"
    )
}