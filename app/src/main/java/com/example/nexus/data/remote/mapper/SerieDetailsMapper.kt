package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.SerieDetailsDto
import com.example.nexus.domain.model.SerieDetails

fun SerieDetailsDto.toDomainSerieDetails(): SerieDetails {
    var posterUrl = ""
    if (posterPath != null && posterPath.isNotEmpty()) {
        posterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + posterPath
    }
    var backdropUrl = ""
    if (backdropPath != null && backdropPath.isNotEmpty()) {
        backdropUrl = BuildConfig.TMDB_IMAGE_BASE_URL + backdropPath
    }

    val defaultRuntime = listOf(60)

    return SerieDetails(
        id = id,
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        adult = adult ?: true,
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        voteAverage = voteAverage ?: 0.0,
        firstAirDate = firstAirDate.orEmpty(),
        episodeRuntime = episodeRuntime ?: defaultRuntime,
        seasons = seasons.map { it.toDomainSeason() }
    )
}