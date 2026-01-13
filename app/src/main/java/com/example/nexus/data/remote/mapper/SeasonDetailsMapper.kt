package com.example.nexus.data.remote.mapper

import com.example.nexus.BuildConfig
import com.example.nexus.data.remote.dto.SeasonDetailsDto
import com.example.nexus.domain.model.SeasonDetails

fun SeasonDetailsDto.toDomainSeasonDetails(): SeasonDetails {
    var posterUrl = ""
    if (posterPath != null && posterPath.isNotEmpty()) {
        posterUrl = BuildConfig.TMDB_IMAGE_BASE_URL + posterPath
    }

    return SeasonDetails(
        airDate = airDate.orEmpty(),
        episodes = episodes.map { it.toDomainEpisode() },
        id = id ?: 0,
        name = name.orEmpty(),
        overview = overview.orEmpty(),
        posterUrl = posterUrl,
        seasonNumber = seasonNumber ?: 0
    )
}